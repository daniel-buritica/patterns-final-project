package co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.postpostgresql;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends ReactiveCrudRepository<Post,Integer> {
}
