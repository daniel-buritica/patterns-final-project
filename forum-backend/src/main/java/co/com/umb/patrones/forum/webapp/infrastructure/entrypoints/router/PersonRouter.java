package co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.router;

import co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.handler.PersonHandle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
@Configuration
public class PersonRouter {

    @Bean
    public RouterFunction<ServerResponse> routerFunctionCarta(PersonHandle handler) {
        return route(POST("/api/v1/person"), handler::save)
                  .andRoute(GET("/api/v1/person"), handler::findAll )
                  .andRoute(PUT("/api/v1/person"), handler::update)
                  .andRoute(DELETE("/api/v1/person/{id}"), handler::delete)
                  .andRoute(GET("/api/v1/person/{id}"), handler::findById)
                .andRoute(GET("/api/v1/person/validate/{email}"), handler::exist);

    }
}
