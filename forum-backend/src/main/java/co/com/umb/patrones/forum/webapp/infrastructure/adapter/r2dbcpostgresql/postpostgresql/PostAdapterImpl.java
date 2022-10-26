package co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.postpostgresql;

import co.com.umb.patrones.forum.webapp.domain.model.PersonModel;
import co.com.umb.patrones.forum.webapp.domain.model.PostModel;
import co.com.umb.patrones.forum.webapp.domain.model.gateway.PostModelRepository;
import co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.postpostgresql.helper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class PostAdapterImpl implements PostModelRepository {

    private final PostRepository postRepository;
    private final PostMapper postMapper;


    @Override
    public Flux<PostModel> getAll() {
        return postRepository.findAll().map(postMapper::toModel);
    }
    @Override
    public Mono<PostModel> update(PostModel postModel) {
        var dataPerson = postMapper.toEntity(postModel);
        return postRepository.findById(postModel.getIdpost())
                .flatMap( p -> postRepository.save(dataPerson))
                .map(postMapper::toModel);
    }

    @Override
    public Mono<Void> delete(Integer idPerson) {
        return postRepository.deleteById(idPerson);
    }

    @Override
    public Mono<PostModel> create(PostModel postModel) {
        var postData = postMapper.toEntity(postModel);
        return postRepository.save(postData)
                .map(postMapper::toModel);
    }

    @Override
    public Mono<PostModel> findById(int id) {
        return postRepository.findById(id)
                .map(postMapper::toModel);
    }

}
