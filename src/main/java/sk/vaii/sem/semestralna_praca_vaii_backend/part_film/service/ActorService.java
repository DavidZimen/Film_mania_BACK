package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.vaii.sem.semestralna_praca_vaii_backend.mapper.ActorMapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.ActorAddDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.ActorUpdateDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Actor;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.FilmPartImage;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.repository.ActorRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ActorService {
    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;
    private final FilmPartImageService filmPartImageService;

    public Actor addActor(ActorAddDto actorAddDto) {
        Actor actor = this.actorMapper.actorAddDtoToActor(actorAddDto);

        //find image and set it ot actor
        Optional<FilmPartImage> image = this.filmPartImageService.getImageById(actorAddDto.getImage_id());
        image.ifPresent(actor::setActorImage);

        return this.actorRepository.save(actor);
    }

    public Actor updateActor(ActorUpdateDto actorUpdateDto) {
        Actor actor = this.actorMapper.actorUpdateDtoToActor(actorUpdateDto);

        //find image and set it ot actor
        Optional<FilmPartImage> image = this.filmPartImageService.getImageById(actorUpdateDto.getImage_id().getId());
        image.ifPresent(actor::setActorImage);

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
        Actor actor = this.actorRepository.getById(id);
        if (actor.getFilms().isEmpty()) {
            this.actorRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Actor can't be assigned to any movie.");
        }
    }

}
