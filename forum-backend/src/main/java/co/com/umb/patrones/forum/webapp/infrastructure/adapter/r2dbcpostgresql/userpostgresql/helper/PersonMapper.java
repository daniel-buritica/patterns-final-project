package co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.userpostgresql.helper;

import co.com.umb.patrones.forum.webapp.model.UserModel;
import co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.personpostgresql.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper implements MapperGeneric<Person, UserModel>{

    @Override
    public Person toEntity(UserModel model) {
        return  Person.builder()
                .cardId(model.getPersonModel().getCardId())
                .name(model.getPersonModel().getName())
                .lastname(model.getPersonModel().getLastname())
                .email(model.getPersonModel().getEmail())
                .dateBirth(model.getPersonModel().getDateBirth())
                .countries(model.getPersonModel().getCountries())
                .city(model.getPersonModel().getCity())
                .profesion(model.getPersonModel().getProfesion())
                .build();
    }

    @Override
    public UserModel toModel(Person entity) {
        return null;
    }
}
