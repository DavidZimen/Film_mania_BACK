package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.DirectorAddDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.DirectorUpdateDto;
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

    @GetMapping("ofFilm/{filmId}")
    public ResponseEntity<Director> getDirectorOfFilm(@PathVariable("filmId")Long filmId) {
        return new ResponseEntity<>(this.directorService.getDirectorOfFilm(filmId), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Director> addDirector(@RequestBody DirectorAddDto directorAddDto) {
        try {
            Director director = this.directorService.addDirector(directorAddDto);
            return new ResponseEntity<>(director, HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Director> updateDirector(@RequestBody DirectorUpdateDto directorUpdateDto) {
        return new ResponseEntity<>(this.directorService.updateDirector(directorUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable("id") Long id) {
        try {
            this.directorService.deleteDirector(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}