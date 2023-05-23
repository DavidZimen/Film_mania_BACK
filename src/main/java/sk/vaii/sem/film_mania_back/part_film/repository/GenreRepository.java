package sk.vaii.sem.film_mania_back.part_film.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.film_mania_back.part_film.entity.Genre;
import sk.vaii.sem.film_mania_back.part_film.repository.dao.GenreDao;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long>, GenreDao {
    Optional<Genre> findByName(String name);
}