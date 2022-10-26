package co.com.umb.patrones.forum.webapp.domain.model.gateway;

import co.com.umb.patrones.forum.webapp.domain.model.PostCommentModel;
import co.com.umb.patrones.forum.webapp.domain.model.PostModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostCommentModelRepository {

    Flux<PostCommentModel> getAll();
    Mono<PostCommentModel> update(PostCommentModel postCommentModel);
    Mono<Void> delete(Integer idPostComment);
    Mono<PostCommentModel> create(PostCommentModel postCommentModel);
    Mono<PostCommentModel> findById(int id);
}
