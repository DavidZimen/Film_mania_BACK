package sk.vaii.sem.film_mania_back.part_film.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.film_mania_back.part_film.entity.Director;
import sk.vaii.sem.film_mania_back.part_film.repository.dao.DirectorDao;

import java.util.Optional;

public interface DirectorRepository extends JpaRepository<Director, Long>, DirectorDao {
    Optional<Director> findByName(String name);
}