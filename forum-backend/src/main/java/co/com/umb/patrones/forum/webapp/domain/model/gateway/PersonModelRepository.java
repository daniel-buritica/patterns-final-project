package co.com.umb.patrones.forum.webapp.domain.model.gateway;

import co.com.umb.patrones.forum.webapp.domain.model.PersonModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonModelRepository {

    Flux<PersonModel> getAll();
    Mono<PersonModel> update(PersonModel personModel);
    Mono<Void> delete(Integer idPerson);
    Mono<PersonModel> create(PersonModel personModel);

    Mono<PersonModel> findById(int id);

    Mono<Boolean> existsByEmail(String email);

    Mono<PersonModel> findByEmail(String email);
}
