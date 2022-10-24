package co.com.umb.patrones.forum.webapp.model.gateway;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GenericRepository <T>{

    Flux<T> getAll();
    Mono<T> update(T object);
    Mono<Void> delete(Integer id);
    Mono<T> create(T object);

    Mono<T> findById(int id);
}
