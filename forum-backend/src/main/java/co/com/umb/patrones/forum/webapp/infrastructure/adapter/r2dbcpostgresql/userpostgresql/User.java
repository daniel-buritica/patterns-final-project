package co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.userpostgresql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("consumer")
public class User {

    @Id
    @Column("id_user")
    private int idUser;
    @Column("id_person")
    private int  idPerson;
    @Column("user_name")
    private String userName;
    @Column("id_rol")
    private int idRol;
}
