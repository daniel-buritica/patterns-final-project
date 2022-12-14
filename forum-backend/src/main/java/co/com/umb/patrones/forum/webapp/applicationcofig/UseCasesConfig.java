package co.com.umb.patrones.forum.webapp.applicationcofig;

import co.com.umb.patrones.forum.webapp.domain.model.gateway.PersonModelRepository;
import co.com.umb.patrones.forum.webapp.domain.model.gateway.PostCommentModelRepository;
import co.com.umb.patrones.forum.webapp.domain.model.gateway.PostModelRepository;
import co.com.umb.patrones.forum.webapp.domain.model.gateway.UserModelRepository;
import co.com.umb.patrones.forum.webapp.domain.usecase.PersonUseCase;
import co.com.umb.patrones.forum.webapp.domain.usecase.PostCommentUseCase;
import co.com.umb.patrones.forum.webapp.domain.usecase.PostUseCase;
import co.com.umb.patrones.forum.webapp.domain.usecase.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {

        @Bean
        public PersonUseCase personUseCase (PersonModelRepository personModelRepository){
                return new PersonUseCase(personModelRepository);
        }

        @Bean
        public UserUseCase userUseCase (UserModelRepository userModelRepository){
                return new UserUseCase(userModelRepository);
        }

        @Bean
        public PostUseCase postUseCase (PostModelRepository postModelRepository){
                return new PostUseCase(postModelRepository);
        }
        @Bean
        public PostCommentUseCase postCommentUseCase (PostCommentModelRepository postCommentModelRepository){
                return new PostCommentUseCase(postCommentModelRepository);
        }
}
