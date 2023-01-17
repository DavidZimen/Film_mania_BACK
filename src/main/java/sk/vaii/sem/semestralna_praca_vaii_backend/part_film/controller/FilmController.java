package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.FilmAddDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.FilmDetailDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.FilmInTableDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.FilmUpdateDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Film;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.service.FilmService;

import java.util.List;

@RestController
@RequestMapping("/film")
@CrossOrigin()
@AllArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @GetMapping(value = {"getById/{filmId}", "getById/{filmId}/{userId}"})
    public ResponseEntity<FilmDetailDto> getFilmById(@PathVariable("filmId") Long filmId, @PathVariable(value = "userId", required = false)Long userId) {
        return new ResponseEntity<>(this.filmService.getFilmById(filmId, userId), HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<Film>> getAllFilms() {
        return new ResponseEntity<>(this.filmService.getAllFilms(), HttpStatus.OK);
    }

    @RequestMapping(value = {"getAllFilms", "getAllFilms/{userId}"})
    public ResponseEntity<List<FilmInTableDto>> getAllFilms(@PathVariable(value = "userId", required = false) Long userId) {
        return new ResponseEntity<>(this.filmService.getAllFilmsForTable(userId), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Film> addFilm(@RequestBody FilmAddDto filmAddDto) {
        return new ResponseEntity<>(this.filmService.addFilm(filmAddDto), HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Film> updateFilm(@RequestBody FilmUpdateDto filmUpdateDto) {
        return new ResponseEntity<>(this.filmService.updateFilm(filmUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteFilm(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.filmService.deleteFilm(id), HttpStatus.OK);
    }
}
