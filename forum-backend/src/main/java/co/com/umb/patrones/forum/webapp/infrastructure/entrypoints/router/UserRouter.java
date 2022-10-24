package co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.router;

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
public class UserRouter {

    @Bean
    public RouterFunction<ServerResponse> routerFunctionCarta2(UserHandler handler) {
        return route(POST("/api/v1/user"), handler::save)
                .andRoute(GET("/api/v1/user"), handler::findAll )
                .andRoute(PUT("/api/v1/user"), handler::update)
                .andRoute(DELETE("/api/v1/user/{id}"), handler::delete)
                .andRoute(GET("/api/v1/user/{id}"), handler::findById);

    }
}
