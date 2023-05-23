package sk.vaii.sem.film_mania_back.part_film.repository.dao;

import org.springframework.stereotype.Repository;
import sk.vaii.sem.film_mania_back.part_film.entity.Actor;

import java.util.List;

@Repository
public interface ActorDao {
    List<Actor> getActorsOfFilm(Long filmId);

    List<Actor> searchActors(String query);
}
