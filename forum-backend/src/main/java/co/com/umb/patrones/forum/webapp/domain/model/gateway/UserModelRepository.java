package co.com.umb.patrones.forum.webapp.domain.model.gateway;

import co.com.umb.patrones.forum.webapp.domain.model.UserModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserModelRepository {
    Flux<UserModel> getAll();
    Mono<UserModel> update(UserModel userModel);
    Mono<Void> delete(Integer idUser);
    Mono<UserModel> create(UserModel userModel);
    Mono<UserModel> findById(int id);
}
