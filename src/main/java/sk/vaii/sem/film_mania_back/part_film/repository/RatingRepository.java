package sk.vaii.sem.film_mania_back.part_film.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.film_mania_back.part_film.entity.Rating;
import sk.vaii.sem.film_mania_back.part_film.repository.dao.RatingDao;

public interface RatingRepository extends JpaRepository<Rating, Long>, RatingDao {
}