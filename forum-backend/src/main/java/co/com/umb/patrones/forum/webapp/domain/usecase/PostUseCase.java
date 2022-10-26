package co.com.umb.patrones.forum.webapp.domain.usecase;

import co.com.umb.patrones.forum.webapp.domain.model.PostModel;
import co.com.umb.patrones.forum.webapp.domain.model.UserModel;
import co.com.umb.patrones.forum.webapp.domain.model.gateway.PostModelRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class PostUseCase {

    private PostModelRepository postModelRepository;

    public Mono<PostModel> getById(int id){
        return postModelRepository.findById(id);
    }
    public Flux<PostModel> getAll(){
        return postModelRepository.getAll();
    }
    public Mono<PostModel> update(PostModel postModel){
        return postModelRepository.update(postModel);
    }
    public Mono<Void> delete(Integer idPost){
        return postModelRepository.delete(idPost);
    }
    public Mono<PostModel> create(PostModel postModel){
        return postModelRepository.create(postModel);
    }
}
