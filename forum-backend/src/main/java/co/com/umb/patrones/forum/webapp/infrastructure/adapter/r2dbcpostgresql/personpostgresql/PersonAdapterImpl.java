package co.com.umb.patrones.forum.webapp.infrastructure.adapter.r2dbcpostgresql.personpostgresql;

import co.com.umb.patrones.forum.webapp.domain.model.PersonModel;
import co.com.umb.patrones.forum.webapp.domain.model.gateway.PersonModelRepository;
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
        return personRepository.findById(id)
                .map(p -> personToPersonModel(p));
    }

    @Override
    public Mono<Boolean> existsByEmail(String email) {
        return personRepository.existsPersonByEmail(email);
    }

    @Override
    public Mono<PersonModel> findByEmail(String email) {
        return personRepository.findByEmail(email)
                .map(p -> personToPersonModel(p));
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
                .profession(personModel.getProfession())
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
                .profession(person.getProfession())
                .build();
    }

}
