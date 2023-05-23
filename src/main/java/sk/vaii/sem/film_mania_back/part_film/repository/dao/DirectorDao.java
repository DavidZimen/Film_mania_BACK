package sk.vaii.sem.film_mania_back.part_film.repository.dao;

import org.springframework.stereotype.Repository;
import sk.vaii.sem.film_mania_back.part_film.entity.Director;

import java.util.List;

@Repository
public interface DirectorDao {
    Director getDirectorOfFilm(Long filmId);

    List<Director> searchDirectors(String query);
}
