package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Director;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.service.DirectorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/director")
@CrossOrigin()
@AllArgsConstructor
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping("byId/{id}")
    public ResponseEntity<Optional<Director>> getDirectorById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.directorService.getDirectorById(id), HttpStatus.OK);
    }

    @GetMapping("byName/{name:[a-zA-Z &+-]*}")
    public ResponseEntity<Optional<Director>> getDirectorByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(this.directorService.getDirectorByName(name), HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<Director>> getAllDirectors() {
        return new ResponseEntity<>(this.directorService.getAllDirectors(), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Director> addDirector(@RequestBody Director director) {
        return new ResponseEntity<>(this.directorService.addDirector(director), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable("id") Long id) {
        this.directorService.deleteDirector(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}