package co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.helper;

import co.com.umb.patrones.forum.webapp.domain.model.UserModel;
import co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.dto.UserModelDTO;

public class UserMapper implements MapperGeneric<UserModel, UserModelDTO>{
    @Override
    public UserModel toModel(UserModelDTO dto) {
        return null;
    }

    @Override
    public UserModelDTO toDTO(UserModel entity) {
        return null;
    }
}
