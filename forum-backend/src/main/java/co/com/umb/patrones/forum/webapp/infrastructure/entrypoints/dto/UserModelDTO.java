package co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModelDTO {

    private PersonModelDTO personModel;
    private String userName;
    private RolModelDTO rolModel;
    private String password;

}
