package co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.router;

import co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.handler.PersonHandle;
import co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.handler.PostHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
@Configuration
public class PostRouter {

    @Bean
    public RouterFunction<ServerResponse> routerFunctionCarta3(PostHandler handler) {
        return route(POST("/api/v1/post"), handler::save)
                .andRoute(GET("/api/v1/post"), handler::findAll )
                .andRoute(PUT("/api/v1/post"), handler::update)
                .andRoute(DELETE("/api/v1/post/{id}"), handler::delete)
                .andRoute(GET("/api/v1/post/{id}"), handler::findById);
    }
}
