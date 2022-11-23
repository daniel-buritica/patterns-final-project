package co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.postpostgresql.helper;

import co.com.umb.patrones.forum.webapp.domain.model.PostModel;
import co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.postpostgresql.Post;
import co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.userpostgresql.helper.MapperGeneric;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;


@Component
public class PostMapper implements MapperGeneric<Post, PostModel> {
    @Override
    public Post toEntity(PostModel model) {
        return Post.builder()
                .idPost(model.getIdPost())
                .idUser(model.getIdUser())
                .bodyPost(model.getBodyPost())
                .category(model.getCategory())
                .datePost(String.valueOf(LocalDateTime.now()))
                .build();
    }

    @Override
    public PostModel toModel(Post entity) {
        return PostModel.builder()
                .idPost(entity.getIdPost())
                .idUser(entity.getIdUser())
                .bodyPost(entity.getBodyPost())
                .category(entity.getCategory())
                .datePost(String.valueOf(LocalDateTime.now()))
                .build();
    }
}
