package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Director;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.dao.DirectorDao;

import java.util.Optional;

public interface DirectorRepository extends JpaRepository<Director, Long>, DirectorDao {
    Optional<Director> findByName(String name);
}