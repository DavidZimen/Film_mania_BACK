package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Actor;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.ActorRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ActorService {
    private final ActorRepository actorRepository;

    public Actor addActor(Actor actor) {
        return this.actorRepository.save(actor);
    }

    public Actor updateActor(Actor actor) {
        return this.actorRepository.save(actor);
    }

    public List<Actor> getAllActors() {
        return this.actorRepository.findAll();
    }

    public Optional<Actor> getActorById(Long id) {
        return this.actorRepository.findById(id);
    }

    public Optional<Actor> getActorByName(String name) {
        return this.actorRepository.findByName(name);
    }

    public void deleteActor(Long id) {
        this.actorRepository.deleteById(id);
    }

}
