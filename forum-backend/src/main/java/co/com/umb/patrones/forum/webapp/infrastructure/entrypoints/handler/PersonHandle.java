package co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.handler;

import co.com.umb.patrones.forum.webapp.domain.model.PersonModel;
import co.com.umb.patrones.forum.webapp.domain.usecase.PersonUseCase;
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
public class PersonHandle {
    private final PersonUseCase personUseCase;


    public Mono<ServerResponse> save(ServerRequest request){
        var personData = request.bodyToMono(PersonModel.class);

        return personData.flatMap(p -> {
            return personUseCase.create(p).flatMap(pM -> ServerResponse
                        .created(URI.create("/api/v1/person/" + pM.getId()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue(pM)));
        });
    }
    public Mono<ServerResponse> findById(ServerRequest request){
        var idPath = request.pathVariable("id");
        return personUseCase.getById(Integer.parseInt(idPath))
                .flatMap(p -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue(p)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> findAll(ServerRequest request){

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(personUseCase.getAll(),PersonModel.class);
    }

    public Mono<ServerResponse> update(ServerRequest request){
        var personData = request.bodyToMono(PersonModel.class);

        return personData.flatMap(p -> {
            return personUseCase.update(p).flatMap(pM -> ServerResponse
                    .created(URI.create("/api/v1/person/" + pM.getId()))
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(fromValue(pM)));
        });
    }

    public Mono<ServerResponse> delete(ServerRequest request){
        var idPath = request.pathVariable("id");
        var personData = personUseCase.getById(Integer.parseInt(idPath));
        return personData.flatMap(p -> personUseCase.delete(p.getId()).then(ServerResponse.noContent().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> exist(ServerRequest request){
        var email = request.pathVariable("email");
        return personUseCase.validateUser(email).flatMap(aBoolean -> ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromValue(aBoolean)));
    }




}
