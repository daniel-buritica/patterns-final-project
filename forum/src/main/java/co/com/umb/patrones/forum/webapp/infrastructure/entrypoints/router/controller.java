package co.com.umb.patrones.forum.webapp.infrastructure.entrypoints.router;

import co.com.umb.patrones.forum.webapp.domain.model.PersonModel;
import co.com.umb.patrones.forum.webapp.domain.usecase.PersonUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v2", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class controller {

    private final PersonUseCase personUseCase;


    @GetMapping(path = "/person")
    public PersonModel create(@RequestBody PersonModel personModel) {

        return personModel;
    }
}
