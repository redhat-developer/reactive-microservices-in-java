package io.vertx.book.message;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;

public class HelloMicroservice extends AbstractVerticle {

    @Override
    public void start() {
        // Receive message from the address 'hello'
        vertx.eventBus().<String>consumer("hello", message -> {
            JsonObject json = new JsonObject()
                .put("served-by", this.toString());
            // Check whether we have received a payload in the
            // incoming message
            if (message.body().isEmpty()) {
                message.reply(json.put("message", "hello"));
            } else {
                message.reply(json.put("message", "hello " + message.body()));
            }
        });
    }

}
