package com.whitetern.vertxdemo.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class VertxServer extends AbstractVerticle {

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        Router router = Router.router(vertx);

        router.route("/hello").handler(this::helloHandler);
        vertx.createHttpServer()
                .requestHandler(router)
                .listen(8081, http -> {
                    if (http.succeeded()) {
                        startPromise.complete();
                        log.info("HTTP server started on port 8081");
                    } else {
                        startPromise.fail(http.cause());
                    }
                });
    }

    private void helloHandler(RoutingContext context) {
        context.response()
                .putHeader("content-type", "text/plain")
                .end("Hello from Vert.x!");
    }
}
