package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.dao;

import org.springframework.stereotype.Repository;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Film;

import java.util.List;

@Repository
public interface FilmDao {
    List<Film> searchFilms(String query);
}
