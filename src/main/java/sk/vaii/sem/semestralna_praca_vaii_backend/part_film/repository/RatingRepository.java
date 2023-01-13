package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}