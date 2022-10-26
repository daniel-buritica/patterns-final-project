package co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.postcommentpostgresql;

import co.com.umb.patrones.forum.webapp.domain.model.PostCommentModel;
import co.com.umb.patrones.forum.webapp.domain.model.PostModel;
import co.com.umb.patrones.forum.webapp.domain.model.gateway.PostCommentModelRepository;
import co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.postcommentpostgresql.helper.PostCommentMapper;
import co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.postpostgresql.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class PostCommentAdapterImpl implements PostCommentModelRepository {

    private final PostCommentRepository postCommentRepository;
    private final PostCommentMapper postCommentMapper;

    @Override
    public Flux<PostCommentModel> getAll() {
        return postCommentRepository.findAll().map(postCommentMapper::toModel);
    }

    @Override
    public Mono<PostCommentModel> update(PostCommentModel postCommentModel) {
        var dataPerson = postCommentMapper.toEntity(postCommentModel);
        return postCommentRepository.findById(postCommentModel.getIdPostComment())
                .flatMap( p -> postCommentRepository.save(dataPerson))
                .map(postCommentMapper::toModel);
    }

    @Override
    public Mono<Void> delete(Integer idPerson) {
        return postCommentRepository.deleteById(idPerson);
    }

    @Override
    public Mono<PostCommentModel> create(PostCommentModel postCommentModel) {
        var postCommentData = postCommentMapper.toEntity(postCommentModel);
        return postCommentRepository.save(postCommentData)
                .map(postCommentMapper::toModel);
    }

    @Override
    public Mono<PostCommentModel> findById(int id) {
        return postCommentRepository.findById(id)
                .map(postCommentMapper::toModel);
    }
}
