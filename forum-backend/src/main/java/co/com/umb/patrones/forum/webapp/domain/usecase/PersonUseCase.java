package co.com.umb.patrones.forum.webapp.domain.usecase;

import co.com.umb.patrones.forum.webapp.domain.model.PersonModel;
import co.com.umb.patrones.forum.webapp.domain.model.gateway.PersonModelRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class PersonUseCase {
    private PersonModelRepository personModelRepository;
    //private GenericRepository<PersonModel> personModelRepository;


    public Mono<PersonModel> getById(int id){
        return personModelRepository.findById(id);
    }
    public Flux<PersonModel> getAll(){
        return personModelRepository.getAll();
    }
    public Mono<PersonModel> update(PersonModel personModel){
        return personModelRepository.update(personModel);
    }
    public Mono<Void> delete(Integer idPersonModel){
        return personModelRepository.delete(idPersonModel);
    }
    public Mono<PersonModel> create(PersonModel personModel){
        return personModelRepository.create(personModel);
    }
    public Mono<Boolean> validateUser(String email) {return personModelRepository.existsByEmail(email); }

}
