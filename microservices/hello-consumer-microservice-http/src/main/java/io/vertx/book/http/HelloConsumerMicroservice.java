package io.vertx.book.http;

import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.rxjava.ext.web.Router;
import io.vertx.rxjava.ext.web.RoutingContext;
import io.vertx.rxjava.ext.web.client.HttpRequest;
import io.vertx.rxjava.ext.web.client.HttpResponse;
import io.vertx.rxjava.ext.web.client.WebClient;
import io.vertx.rxjava.ext.web.codec.BodyCodec;
import rx.Single;

public class HelloConsumerMicroservice extends AbstractVerticle {

    private WebClient client;

    @Override
    public void start() {
        client = WebClient.create(vertx);

        Router router = Router.router(vertx);
        router.get("/").handler(this::invokeMyFirstMicroservice);

        vertx.createHttpServer()
            .requestHandler(router::accept)
            .listen(8081);
    }

    private void invokeMyFirstMicroservice(RoutingContext rc) {
        HttpRequest<JsonObject> request1 = client
            .get(8080, "localhost", "/Luke")
            .as(BodyCodec.jsonObject());

        HttpRequest<JsonObject> request2 = client
            .get(8080, "localhost", "/Leia")
            .as(BodyCodec.jsonObject());

        Single<HttpResponse<JsonObject>> s1 = request1.rxSend();
        Single<HttpResponse<JsonObject>> s2 = request2.rxSend();

        Single.zip(s1, s2, (luke, leia) -> {
            // We have the result of both request in Luke and Leia
            return new JsonObject()
                .put("luke", luke.body().getString("message"))
                .put("leia", leia.body().getString("message"));
        }).subscribe(
            x -> {
                rc.response().end(x.encode());
            },
            t -> {
                rc.response().end(new JsonObject().encodePrettily());
            });
    }

}
