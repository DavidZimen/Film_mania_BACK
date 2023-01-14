package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Rating;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.dao.RatingDao;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long>, RatingDao {
}