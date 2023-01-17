package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.RatingAddDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.RatingUpdateDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Rating;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.service.RatingService;

import java.util.Optional;


@RestController
@RequestMapping("/rating")
@CrossOrigin()
@AllArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @GetMapping("get/{userId}/{filmId}")
    public ResponseEntity<Optional<Rating>> getUserRatingOfFilm(@PathVariable("userId") Long userId, @PathVariable("filmId") Long filmId) {
        return new ResponseEntity<>(this.ratingService.getUserRatingOfFilm(userId, filmId), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Integer> addRating(@RequestBody RatingAddDto ratingAddDto) {
        return new ResponseEntity<>(this.ratingService.addRating(ratingAddDto).getRating(), HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Integer> updateRating(@RequestBody RatingUpdateDto ratingUpdateDto) {
        return new ResponseEntity<>(this.ratingService.updateRating(ratingUpdateDto).getRating(), HttpStatus.OK);
    }

}
