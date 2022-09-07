package co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.personpostgresql;

import co.com.umb.patrones.forum.webapp.domain.model.PersonModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ReactiveCrudRepository<Person,Integer> {
}
