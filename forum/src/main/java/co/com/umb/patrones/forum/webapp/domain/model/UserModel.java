package co.com.umb.patrones.forum.webapp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private int idUser;
    private PersonModel personModel;
    private String userName;
    private RolModel rolModel;
    private String password;

}
