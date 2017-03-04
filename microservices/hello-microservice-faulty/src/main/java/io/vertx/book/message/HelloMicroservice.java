package io.vertx.book.message;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;

import java.util.Random;

public class HelloMicroservice extends AbstractVerticle {

    @Override
    public void start() {
        Random random = new Random();
        vertx.eventBus().<String>consumer("hello", message -> {
            int chaos = random.nextInt(10);
            JsonObject json = new JsonObject()
                .put("served-by", this.toString());

            if (chaos < 6) {
                // Normal behavior
                if (message.body().isEmpty()) {
                    message.reply(json.put("message", "hello"));
                } else {
                    message.reply(json.put("message", "hello " + message.body()));
                }
            } else if (chaos < 9) {
                System.out.println("Returning a failure");
                // Reply with a failure
                message.fail(500, "message processing failure");
            } else {
                System.out.println("Not replying");
                // Just do not reply, leading to a timeout on the consumer side.
            }
        });
    }

}
