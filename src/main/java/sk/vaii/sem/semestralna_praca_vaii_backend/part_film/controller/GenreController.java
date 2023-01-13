package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Genre;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.service.GenreService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genre")
@CrossOrigin()
@AllArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping("byId/{id}")
    public ResponseEntity<Optional<Genre>> getGenreById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.genreService.getGenreById(id), HttpStatus.OK);
    }

    @GetMapping("byName/{name:[a-zA-Z &+-]*}")
    public ResponseEntity<Optional<Genre>> getGenreByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(this.genreService.getGenreByName(name), HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<Genre>> getAllGenres() {
        return new ResponseEntity<>(this.genreService.getAllGenres(), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Genre> addGenre(@RequestBody Genre Genre) {
        return new ResponseEntity<>(this.genreService.addGenre(Genre), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable("id") Long id) {
        this.genreService.deleteGenre(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}