package sk.vaii.sem.film_mania_back.part_film.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.vaii.sem.film_mania_back.part_film.service.GenreService;
import sk.vaii.sem.film_mania_back.part_film.entity.Genre;

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

    @GetMapping("allOfFilm/{filmId}")
    public ResponseEntity<List<Genre>> getGenresOfFilm(@PathVariable("filmId") Long filmId) {
        return new ResponseEntity<>(this.genreService.getGenresOfFilm(filmId), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Genre> addGenre(@RequestParam String genreName) {
        return new ResponseEntity<>(this.genreService.addGenre(genreName), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable("id") Long id) {
        try {
            this.genreService.deleteGenre(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}