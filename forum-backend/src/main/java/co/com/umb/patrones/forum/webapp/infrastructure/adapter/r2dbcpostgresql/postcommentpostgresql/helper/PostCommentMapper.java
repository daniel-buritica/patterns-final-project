package co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.postcommentpostgresql.helper;

import co.com.umb.patrones.forum.webapp.domain.model.PostCommentModel;
import co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.postcommentpostgresql.PostComment;
import co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.userpostgresql.helper.MapperGeneric;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class PostCommentMapper implements MapperGeneric<PostComment, PostCommentModel> {

    @Override
    public PostComment toEntity(PostCommentModel model) {
        return PostComment.builder()
                .idPostComment(model.getIdPostComment())
                .idPost(model.getIdPost())
                .bodyPostComment(model.getBodyPostComment())
                .datePostComment(String.valueOf(LocalDateTime.now()))
                .importance(model.getImportance())
                .build();
    }

    @Override
    public PostCommentModel toModel(PostComment entity) {
        return PostCommentModel.builder()
                .idPostComment(entity.getIdPostComment())
                .idPost(entity.getIdPost())
                .bodyPostComment(entity.getBodyPostComment())
                .datePostComment(String.valueOf(LocalDateTime.now()))
                .importance(entity.getImportance())
                .build();
    }
}
