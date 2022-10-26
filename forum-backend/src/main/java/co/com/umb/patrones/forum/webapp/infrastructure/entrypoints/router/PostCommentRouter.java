package co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.router;

import co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.handler.PostCommentHandler;
import co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
@Configuration
public class PostCommentRouter {

    @Bean
    public RouterFunction<ServerResponse> routerFunctionCarta4(PostCommentHandler handler) {
        return route(POST("/api/v1/post-comment"), handler::save)
                .andRoute(GET("/api/v1/post-comment"), handler::findAll )
                .andRoute(PUT("/api/v1/post-comment"), handler::update)
                .andRoute(DELETE("/api/v1/post-comment/{id}"), handler::delete)
                .andRoute(GET("/api/v1/post-comment/{id}"), handler::findById);

    }
}
