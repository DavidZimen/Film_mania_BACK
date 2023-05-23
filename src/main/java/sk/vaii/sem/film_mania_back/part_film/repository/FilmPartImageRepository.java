package sk.vaii.sem.film_mania_back.part_film.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.film_mania_back.part_film.entity.FilmPartImage;
import sk.vaii.sem.film_mania_back.part_film.repository.dao.FilmPartImageDao;

public interface FilmPartImageRepository extends JpaRepository<FilmPartImage, Long>, FilmPartImageDao {
}