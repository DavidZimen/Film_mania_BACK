package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.ActorAddDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.ActorUpdateDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Actor;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.service.ActorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actor")
@CrossOrigin()
@AllArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @GetMapping("byId/{id}")
    public ResponseEntity<Optional<Actor>> getActorById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.actorService.getActorById(id), HttpStatus.OK);
    }

    @GetMapping("byName/{name:[a-zA-Z &+-]*}")
    public ResponseEntity<Optional<Actor>> getActorByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(this.actorService.getActorByName(name), HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<Actor>> getAllActors() {
        return new ResponseEntity<>(this.actorService.getAllActors(), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Actor> addActor(@RequestBody ActorAddDto actorAddDto) {
        return new ResponseEntity<>(this.actorService.addActor(actorAddDto), HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Actor> updateActor(@RequestBody ActorUpdateDto actorUpdateDto) {
        return new ResponseEntity<>(this.actorService.updateActor(actorUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable("id") Long id) {
        try {
            this.actorService.deleteActor(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
