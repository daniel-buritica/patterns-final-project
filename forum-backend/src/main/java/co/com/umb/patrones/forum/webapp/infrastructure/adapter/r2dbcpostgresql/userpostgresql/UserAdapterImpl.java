package co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.userpostgresql;

import co.com.umb.patrones.forum.webapp.domain.model.UserModel;
import co.com.umb.patrones.forum.webapp.domain.model.gateway.UserModelRepository;
import co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.personpostgresql.Person;
import co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.personpostgresql.PersonRepository;
import co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.userpostgresql.helper.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;
import java.util.function.Function;

@RequiredArgsConstructor
@Component
public class UserAdapterImpl implements UserModelRepository {
    private final UserRepository userRepository;
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public Flux<UserModel> getAll() {
        return null;
    }

    @Override
    public Mono<UserModel> update(UserModel userModel) {
        return null;
    }

    @Override
    public Mono<Void> delete(Integer idUser) {
        return null;
    }

    @Override
    public Mono<UserModel> create(UserModel userModel) {
        var personData = personMapper.toEntity(userModel);
        return personRepository.save(personData)
                .flatMap(p -> userRepository.save(mapper.apply(userModel,p))
                        .map(userToUserModel));
    }

    private final Function<User,UserModel> userToUserModel = user -> UserModel.builder()
            .idUser(user.getIdUser())
            .userName(user.getUserName())
            .build();

    private final BiFunction<UserModel, Person, User> mapper = (userModel, person) ->
                         User.builder()
                            .idPerson(person.getId())
                            .userName(userModel.getUserName())
                            .idRol(userModel.getRolModel().getRol().equals("user") ?1:2)
                            .build();

    @Override
    public Mono<UserModel> findById(int id) {
        return null;
    }
}
