package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.dao;

import org.springframework.stereotype.Repository;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Genre;

import java.util.List;

@Repository
public interface GenreDao {
    List<Genre> getGenresOfFilm(Long filmId);
}
