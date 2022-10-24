package co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.helper;

import co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.personpostgresql.Person;
import co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.dto.PersonModelDTO;

public class PersonMapper implements MapperGeneric<Person, PersonModelDTO>{
    @Override
    public Person toModel(PersonModelDTO dto) {
        return null;
    }

    @Override
    public PersonModelDTO toDTO(Person entity) {
        return null;
    }
}
