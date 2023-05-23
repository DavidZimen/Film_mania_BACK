package sk.vaii.sem.film_mania_back.part_film.repository.dao;

import org.springframework.stereotype.Repository;
import sk.vaii.sem.film_mania_back.part_film.entity.Genre;

import java.util.List;

@Repository
public interface GenreDao {
    List<Genre> getGenresOfFilm(Long filmId);
}
