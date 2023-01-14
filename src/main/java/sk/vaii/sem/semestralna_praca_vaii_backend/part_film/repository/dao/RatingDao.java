package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.dao;

import org.springframework.stereotype.Repository;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Rating;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingDao {
    List<Rating> getRatingsOfFilm(Long filmId);
    Optional<Rating> getRatingOfUserToTheFilm(Long userId, Long filmId);
}
