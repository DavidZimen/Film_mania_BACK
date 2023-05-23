package sk.vaii.sem.film_mania_back.part_film.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.film_mania_back.part_film.entity.Film;
import sk.vaii.sem.film_mania_back.part_film.repository.dao.FilmDao;

public interface FilmRepository extends JpaRepository<Film, Long>, FilmDao {
}