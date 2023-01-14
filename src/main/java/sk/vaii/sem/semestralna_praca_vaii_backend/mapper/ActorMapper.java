package sk.vaii.sem.semestralna_praca_vaii_backend.mapper;

import org.mapstruct.Mapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.ActorAddDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.ActorUpdateDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Actor;

@Mapper
public interface ActorMapper {
    Actor actorAddDtoToActor(ActorAddDto actorAddDto);
    Actor actorUpdateDtoToActor(ActorUpdateDto actorUpdateDto);
}
