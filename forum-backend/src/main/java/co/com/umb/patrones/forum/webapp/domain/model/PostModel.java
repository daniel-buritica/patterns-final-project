package co.com.umb.patrones.forum.webapp.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostModel {

    private int idpost;
    private int idUser;
    private String bodyPost;
    private String category;
    private String datePost;


}
