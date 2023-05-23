package sk.vaii.sem.film_mania_back.part_film.repository.dao;

import org.springframework.stereotype.Repository;
import sk.vaii.sem.film_mania_back.part_film.entity.FilmPartImage;

import java.util.Optional;

@Repository
public interface FilmPartImageDao {
    Optional<FilmPartImage> getImageOfFilm(Long filmId);
}
