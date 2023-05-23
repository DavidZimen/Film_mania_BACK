package sk.vaii.sem.film_mania_back.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sk.vaii.sem.film_mania_back.part_film.dto.ActorAddDto;
import sk.vaii.sem.film_mania_back.part_film.dto.ActorUpdateDto;
import sk.vaii.sem.film_mania_back.part_film.entity.Actor;
import sk.vaii.sem.film_mania_back.searching.dto.SearchResultDto;
import sk.vaii.sem.film_mania_back.searching.mapper.SearchResultMapper;

import java.util.List;

@Mapper
public interface ActorMapper extends SearchResultMapper<Actor> {
    Actor actorAddDtoToActor(ActorAddDto actorAddDto);

    Actor actorUpdateDtoToActor(ActorUpdateDto actorUpdateDto);

    @Override
    @Mapping(target = "name", source = "value.name")
    @Mapping(target = "resultLocalId", source = "value.id")
    SearchResultDto toSearchResultDto(Actor value);

    @Override
    List<SearchResultDto> toSearchResultDtoList(List<Actor> values);
}
