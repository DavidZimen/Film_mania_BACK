package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Film;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.dao.FilmDao;

public interface FilmRepository extends JpaRepository<Film, Long>, FilmDao {
}