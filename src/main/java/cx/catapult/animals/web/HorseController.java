package cx.catapult.animals.web;

import cx.catapult.animals.domain.Horse;
import cx.catapult.animals.service.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/api/1/horses", produces = MediaType.APPLICATION_JSON_VALUE)
public class HorseController {

    @Autowired
    private HorseService service;

    @GetMapping(value = "", produces = "application/json")
    public @ResponseBody
    Collection<Horse> all() {
        return service.all();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    Horse get(@PathVariable String id) {
        return service.get(id);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    Horse
    create(@RequestBody Horse horse) {
        return service.create(horse);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody
    Boolean
    delete(@PathVariable String id) {
         return service.delete(id);
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Horse
    update(@RequestBody Horse horse) {
        return service.update(horse);
    }

}
