package co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.postcommentpostgresql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCommentRepository extends ReactiveCrudRepository<PostComment, Integer> {
}
