package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Actor;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.dao.ActorDao;

import java.util.Optional;

public interface ActorRepository extends JpaRepository<Actor, Long>, ActorDao {
    Optional<Actor> findByName(String name);
}