package sk.vaii.sem.film_mania_back.part_film.repository.dao;

import org.springframework.stereotype.Repository;
import sk.vaii.sem.film_mania_back.part_film.entity.Rating;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingDao {
    List<Rating> getRatingsOfFilm(Long filmId);
    Optional<Rating> getRatingOfUserToTheFilm(Long userId, Long filmId);
}
