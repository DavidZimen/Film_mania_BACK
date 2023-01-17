package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.dao;

import org.springframework.stereotype.Repository;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Director;

@Repository
public interface DirectorDao {
    Director getDirectorOfFilm(Long filmId);
}
