package co.com.umb.patrones.forum.webapp.domain.usecase;

import co.com.umb.patrones.forum.webapp.domain.model.PostCommentModel;
import co.com.umb.patrones.forum.webapp.domain.model.PostModel;
import co.com.umb.patrones.forum.webapp.domain.model.gateway.PostCommentModelRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class PostCommentUseCase  {

    private PostCommentModelRepository postCommentModelRepository;

    public Mono<PostCommentModel> getById(int id){
        return postCommentModelRepository.findById(id);
    }
    public Flux<PostCommentModel> getAll(){
        return postCommentModelRepository.getAll();
    }
    public Mono<PostCommentModel> update(PostCommentModel postCommentModel){
        return postCommentModelRepository.update(postCommentModel);
    }
    public Mono<Void> delete(Integer idPost){
        return postCommentModelRepository.delete(idPost);
    }
    public Mono<PostCommentModel> create(PostCommentModel postCommentModel){
        return postCommentModelRepository.create(postCommentModel);
    }

}
