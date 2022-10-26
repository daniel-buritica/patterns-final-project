package co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.postcommentpostgresql;


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
@Table("post_comment")
public class PostComment {

    @Id
    @Column("id_post_comment")
    private int idPostComment;
    @Column("id_post")
    private int idPost;
    @Column("body_post_comment")
    private String bodyPostComment;
    @Column("date_post_comment")
    private String datePostComment;
    @Column("importance")
    private int importance;
}
