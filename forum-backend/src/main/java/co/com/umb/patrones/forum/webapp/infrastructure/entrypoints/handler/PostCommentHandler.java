package co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.handler;

import co.com.umb.patrones.forum.webapp.domain.model.PostCommentModel;
import co.com.umb.patrones.forum.webapp.domain.usecase.PostCommentUseCase;
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
public class PostCommentHandler {

    private final PostCommentUseCase postCommentUseCase;

    public Mono<ServerResponse> save(ServerRequest request){
        var personData = request.bodyToMono(PostCommentModel.class);

        return personData.flatMap(p -> {
            return postCommentUseCase.create(p).flatMap(pM -> ServerResponse
                    .created(URI.create("/api/v1/post-comment/" + pM.getIdPostComment()))
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(fromValue(pM)));
        });
    }
    public Mono<ServerResponse> findById(ServerRequest request){
        var idPath = request.pathVariable("id");
        return postCommentUseCase.getById(Integer.parseInt(idPath))
                .flatMap(p -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue(p)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> findAll(ServerRequest request){

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(postCommentUseCase.getAll(),PostCommentModel.class);
    }

    public Mono<ServerResponse> update(ServerRequest request){
        var personData = request.bodyToMono(PostCommentModel.class);

        return personData.flatMap(p -> {
            return postCommentUseCase.update(p).flatMap(pM -> ServerResponse
                    .created(URI.create("/api/v1/post-comment/" + pM.getIdPostComment()))
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(fromValue(pM)));
        });
    }

    public Mono<ServerResponse> delete(ServerRequest request){
        var idPath = request.pathVariable("id");
        var personData = postCommentUseCase.getById(Integer.parseInt(idPath));
        return personData.flatMap(u -> postCommentUseCase.delete(u.getIdPostComment()).then(ServerResponse.noContent().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }




}
