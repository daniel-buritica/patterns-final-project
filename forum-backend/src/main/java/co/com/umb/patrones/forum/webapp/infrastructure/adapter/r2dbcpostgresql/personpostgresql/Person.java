package co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.personpostgresql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("person")
public class Person {

    @Id
    @Column("id_person")
    private int id;
    @Column("id_card")
    private int cardId;
    @Column("name")
    private String name;
    @Column("last_name")
    private String lastname;
    @Column("email")
    private String email;
    @Column("date_birth")
    private String dateBirth;
    @Column("countries")
    private String countries;
    @Column("city")
    private String city;
    @Column("profession")
    private String profession;


}


