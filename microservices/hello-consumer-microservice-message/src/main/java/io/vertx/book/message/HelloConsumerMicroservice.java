package io.vertx.book.message;

import io.vertx.core.json.JsonObject;
import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.core.eventbus.Message;
import rx.Single;

public class HelloConsumerMicroservice extends AbstractVerticle {

    @Override
    public void start() {
        vertx.createHttpServer()
            .requestHandler(
                req -> {
                    Single<JsonObject> obs1 = vertx.eventBus()
                        .<JsonObject>rxSend("hello", "Luke")
                        .map(Message::body);
                    Single<JsonObject> obs2 = vertx.eventBus()
                        .<JsonObject>rxSend("hello", "Leia")
                        .map(Message::body);

                    Single
                        .zip(obs1, obs2, (luke, leia) ->
                            new JsonObject()
                                .put("Luke", luke.getString("message")
                                    + " from " + luke.getString("served-by"))
                                .put("Leia", leia.getString("message")
                                    + " from " + leia.getString("served-by"))
                        )
                        .subscribe(
                            x -> req.response().end(x.encodePrettily()),
                            t -> req.response().setStatusCode(500).end(t.getMessage())
                        );
                })
            .listen(8082);
    }

}
