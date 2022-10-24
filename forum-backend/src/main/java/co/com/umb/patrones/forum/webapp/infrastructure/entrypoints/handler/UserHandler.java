package co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.handler;

import co.com.umb.patrones.forum.webapp.model.UserModel;
import co.com.umb.patrones.forum.webapp.domain.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
@RequiredArgsConstructor
public class UserHandler {

    private final UserUseCase userUseCase;


    public Mono<ServerResponse> save(ServerRequest request){
        var userData = request.bodyToMono(UserModel.class);
        return userData.flatMap(u -> {
            return userUseCase.create(u).flatMap(pU -> ServerResponse
                    .created(URI.create("/api/v1/user/" + pU.getIdUser()))
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(fromValue(pU)));
        });
    }
    public Mono<ServerResponse> findById(ServerRequest request){
        var idPath = request.pathVariable("id");
        return userUseCase.getById(Integer.parseInt(idPath))
                .flatMap(p -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue(p)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> findAll(ServerRequest request){

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userUseCase.getAll(),UserModel.class);
    }

    public Mono<ServerResponse> update(ServerRequest request){
        var userData = request.bodyToMono(UserModel.class);

        return userData.flatMap(u -> {
            return userUseCase.update(u).flatMap(pU -> ServerResponse
                    .created(URI.create("/api/v1/user/" + pU.getIdUser()))
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(fromValue(pU)));
        });
    }

    public Mono<ServerResponse> delete(ServerRequest request){
        var idPath = request.pathVariable("id");
        var personData = userUseCase.getById(Integer.parseInt(idPath));
        return personData.flatMap(u -> userUseCase.delete(u.getIdUser()).then(ServerResponse.noContent().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }



}
