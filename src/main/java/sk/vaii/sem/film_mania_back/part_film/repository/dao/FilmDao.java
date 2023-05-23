package sk.vaii.sem.film_mania_back.part_film.repository.dao;

import org.springframework.stereotype.Repository;
import sk.vaii.sem.film_mania_back.part_film.entity.Film;

import java.util.List;

@Repository
public interface FilmDao {
    List<Film> searchFilms(String query);
}
