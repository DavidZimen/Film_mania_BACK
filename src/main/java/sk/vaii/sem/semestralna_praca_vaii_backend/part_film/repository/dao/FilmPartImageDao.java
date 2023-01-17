package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.dao;

import org.springframework.stereotype.Repository;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.FilmPartImage;

import java.util.Optional;

@Repository
public interface FilmPartImageDao {
    Optional<FilmPartImage> getImageOfFilm(Long filmId);
}
