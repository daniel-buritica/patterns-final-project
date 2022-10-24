package co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.userpostgresql;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User,Integer> {

}
