package co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.userpostgresql.helper;

import co.com.umb.patrones.forum.webapp.domain.model.UserModel;
import co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.userpostgresql.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements MapperGeneric<User, UserModel> {


    @Override
    public User toEntity(UserModel model) {
        return User.builder()
                .idPerson(model.getPersonModel().getId())
                .userName(model.getUserName())
                .idRol(model.getRolModel().getRol().equals("user") ? 1:2)
                .build();
    }

    @Override
    public UserModel toModel(User entity) {
        return UserModel.builder()
                .build();
    }
}
