package co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.postpostgresql;


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
@Table("post")
public class Post {

    @Id
    @Column("id_post")
    private int idPost;
    @Column("id_user")
    private int idUser;
    @Column("body_post")
    private String bodyPost;
    @Column("category")
    private String category;
    @Column("date_post")
    private String datePost;
}
