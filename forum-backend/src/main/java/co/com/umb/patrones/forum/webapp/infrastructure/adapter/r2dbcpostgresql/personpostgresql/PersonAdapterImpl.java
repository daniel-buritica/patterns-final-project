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
        return personRepository.findAll().map(p ->
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

    @Override
    public Mono<PersonModel> update(PersonModel personModel) {
        return personRepository.findById(personModel.getId())
                .flatMap( p -> personRepository.save(
                        Person.builder()
                                .id(personModel.getId())
                                .name(personModel.getName())
                                .lastname(personModel.getLastname())
                                .email(personModel.getEmail())
                                .dateBirth(personModel.getDateBirth())
                                .countries(personModel.getCountries())
                                .city(personModel.getCity())
                                .profesion(personModel.getProfesion())
                                .build())).map(p2 ->
                                    PersonModel.builder()
                                            .id(p2.getId())
                                            .name(p2.getName())
                                            .lastname(p2.getLastname())
                                            .email(p2.getEmail())
                                            .dateBirth(p2.getDateBirth())
                                            .countries(p2.getCountries())
                                            .city(p2.getCity())
                                            .profesion(p2.getProfesion())
                                            .build());

    }

    @Override
    public Mono<Void> delete(Integer idPerson) {
        return personRepository.deleteById(idPerson);
    }

    @Override
    public Mono<PersonModel> create(PersonModel personModel) {

        var personData = Person.builder()
                .id(personModel.getId())
                .name(personModel.getName())
                .lastname(personModel.getLastname())
                .email(personModel.getEmail())
                .dateBirth(personModel.getDateBirth())
                .countries(personModel.getCountries())
                .city(personModel.getCity())
                .profesion(personModel.getProfesion())
                .build();

        return personRepository.save(personData).map(p ->
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



}
