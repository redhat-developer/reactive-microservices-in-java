package io.vertx.book.openshift;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.healthchecks.HealthCheckHandler;
import io.vertx.ext.healthchecks.Status;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class HelloHttpVerticle extends AbstractVerticle {

    private boolean started;

    @Override
    public void start() {
        Router router = Router.router(vertx);
        router.get("/").handler(this::hello);
        router.get("/:name").handler(this::hello);
        router.get("/health").handler(HealthCheckHandler.create(vertx).register("http-server-running",
            future -> future.complete(started ? Status.OK() : Status.KO())));

        vertx.createHttpServer()
            .requestHandler(router::accept)
            .listen(8080, ar -> started = ar.succeeded());
    }

    private void hello(RoutingContext rc) {
        String message = "hello";
        if (rc.pathParam("name") != null) {
            message += " " + rc.pathParam("name");
        }
        JsonObject json = new JsonObject()
            .put("message", message)
            .put("served-by", System.getenv("HOSTNAME"));
        rc.response()
            .putHeader(HttpHeaders.CONTENT_TYPE, "application/json")
            .end(json.encode());
    }
}
