package co.com.umb.patrones.forum.webapp.domain.usecase;

import co.com.umb.patrones.forum.webapp.model.UserModel;
import co.com.umb.patrones.forum.webapp.model.gateway.UserModelRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class UserUseCase {
    private UserModelRepository userModelRepository;


    public Mono<UserModel> getById(int id){
        return userModelRepository.findById(id);
    }
    public Flux<UserModel> getAll(){
        return userModelRepository.getAll();
    }
    public Mono<UserModel> update(UserModel userModel){
        return userModelRepository.update(userModel);
    }
    public Mono<Void> delete(Integer idUserModel){
        return userModelRepository.delete(idUserModel);
    }
    public Mono<UserModel> create(UserModel userModel){
        return userModelRepository.create(userModel);
    }

}
