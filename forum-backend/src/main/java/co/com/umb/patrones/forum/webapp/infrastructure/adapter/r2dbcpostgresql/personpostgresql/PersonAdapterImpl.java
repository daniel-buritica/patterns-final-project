package co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.personpostgresql;

import co.com.umb.patrones.forum.webapp.model.PersonModel;
import co.com.umb.patrones.forum.webapp.model.gateway.PersonModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class PersonAdapterImpl implements PersonModelRepository {

    private final  PersonRepository personRepository;
    @Override
    public Flux<PersonModel> getAll() {
        return personRepository.findAll().map(p -> personToPersonModel(p));
    }

    @Override
    public Mono<PersonModel> update(PersonModel personModel) {
        var dataPerson = personModelToPerson(personModel);
        return personRepository.findById(personModel.getId())
                .flatMap( p -> personRepository.save(dataPerson))
                .map(p2 -> personToPersonModel(p2));
    }

    @Override
    public Mono<Void> delete(Integer idPerson) {
        return personRepository.deleteById(idPerson);
    }

    @Override
    public Mono<PersonModel> create(PersonModel personModel) {
        var personData = personModelToPerson(personModel);
        return personRepository.save(personData)
                .map(p -> personToPersonModel(p));
    }

    @Override
    public Mono<PersonModel> findById(int id) {
        return personRepository.findById(id).map(p ->
                PersonModel.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .lastname(p.getLastname())
                        .email(p.getEmail())
                        .dateBirth(p.getDateBirth())
                        .countries(p.getCountries())
                        .city(p.getCity())
                        .profesion(p.getProfesion())
                        .build());
    }

    private Person personModelToPerson(PersonModel personModel){
        return Person.builder()
                .id(personModel.getId())
                .cardId(personModel.getCardId())
                .name(personModel.getName())
                .lastname(personModel.getLastname())
                .email(personModel.getEmail())
                .dateBirth(personModel.getDateBirth())
                .countries(personModel.getCountries())
                .city(personModel.getCity())
                .profesion(personModel.getProfesion())
                .build();
    }
    private PersonModel personToPersonModel(Person person){
        return PersonModel.builder()
                .id(person.getId())
                .cardId(person.getCardId())
                .name(person.getName())
                .lastname(person.getLastname())
                .email(person.getEmail())
                .dateBirth(person.getDateBirth())
                .countries(person.getCountries())
                .city(person.getCity())
                .profesion(person.getProfesion())
                .build();
    }

}
