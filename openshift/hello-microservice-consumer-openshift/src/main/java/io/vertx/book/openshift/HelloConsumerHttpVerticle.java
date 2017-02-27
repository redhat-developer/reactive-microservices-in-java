package io.vertx.book.openshift;

import io.vertx.core.json.JsonObject;
import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.ext.web.Router;
import io.vertx.rxjava.ext.web.RoutingContext;
import io.vertx.rxjava.ext.web.client.HttpRequest;
import io.vertx.rxjava.ext.web.client.HttpResponse;
import io.vertx.rxjava.ext.web.client.WebClient;
import io.vertx.rxjava.ext.web.codec.BodyCodec;
import io.vertx.rxjava.servicediscovery.ServiceDiscovery;
import io.vertx.rxjava.servicediscovery.types.HttpEndpoint;
import rx.Single;

public class HelloConsumerHttpVerticle extends AbstractVerticle {

    private WebClient hello;

    @Override
    public void start() {
        Router router = Router.router(vertx);
        router.get("/").handler(this::invokeHelloMicroservice);

        // Create the service discovery instance
        ServiceDiscovery.create(vertx, discovery -> {
            // Look for a HTTP endpoint named "hello-microservice"
            Single<WebClient> single = HttpEndpoint.rxGetWebClient(discovery,
                rec -> rec.getName().equalsIgnoreCase("hello-microservice"),
                new JsonObject().put("keepAlive", false));

            single.subscribe(
                client -> {
                    // the configured hello to call our microservice
                    this.hello = client;
                    // start the HTTP server
                    vertx.createHttpServer()
                        .requestHandler(router::accept)
                        .listen(8080);
                },
                err -> System.out.println("Oh no, no service")
            );
        });

    }


    private void invokeHelloMicroservice(RoutingContext rc) {
        HttpRequest<JsonObject> request1 = hello.get("/Luke").as(BodyCodec.jsonObject());

        HttpRequest<JsonObject> request2 = hello.get("/Leia").as(BodyCodec.jsonObject());

        Single<HttpResponse<JsonObject>> s1 = request1.rxSend();
        Single<HttpResponse<JsonObject>> s2 = request2.rxSend();

        Single.zip(s1, s2, (luke, leia) -> {
            // We have the result of both request in Luke and Leia
            return new JsonObject()
                .put("luke", luke.body().getString("message")
                    + " " + luke.body().getString("served-by"))
                .put("leia", leia.body().getString("message")
                    + " " + leia.body().getString("served-by"));
        }).subscribe(
            x -> rc.response().end(x.encodePrettily()),
            t -> rc.response().end(new JsonObject().encodePrettily()));
    }
}
