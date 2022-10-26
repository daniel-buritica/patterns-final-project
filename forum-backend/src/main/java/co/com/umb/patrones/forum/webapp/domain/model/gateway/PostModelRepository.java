package co.com.umb.patrones.forum.webapp.domain.model.gateway;

import co.com.umb.patrones.forum.webapp.domain.model.PostModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostModelRepository {

    Flux<PostModel> getAll();
    Mono<PostModel> update(PostModel postModel);
    Mono<Void> delete(Integer idPost);
    Mono<PostModel> create(PostModel postModel);
    Mono<PostModel> findById(int id);
}
