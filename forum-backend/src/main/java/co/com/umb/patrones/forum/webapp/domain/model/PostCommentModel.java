package co.com.umb.patrones.forum.webapp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostCommentModel {

    private int idPostComment;
    private int idPost;
    private String bodyPostComment;
    private String  datePostComment;
    private int importance;
}
