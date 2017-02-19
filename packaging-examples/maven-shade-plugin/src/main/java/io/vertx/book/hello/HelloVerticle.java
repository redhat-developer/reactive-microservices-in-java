package io.vertx.book.hello;

import io.vertx.core.AbstractVerticle;

/**
 * A simple verticle starting a HTTP server and returning "Hello from Vert.x".
 *
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class HelloVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        vertx.createHttpServer()
            .requestHandler(req -> {
                req.response().end("Hello from Vert.x");
            })
            .listen(8080);
    }

}
