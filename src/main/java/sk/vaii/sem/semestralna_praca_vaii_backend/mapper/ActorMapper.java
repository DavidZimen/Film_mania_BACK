package sk.vaii.sem.semestralna_praca_vaii_backend.mapper;

import com.scheidtbachmann.ps.search.searchextension.dto.SearchResult;
import com.scheidtbachmann.ps.search.searchextension.mapper.SearchResultMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.ActorAddDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.ActorUpdateDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Actor;

@Mapper
public interface ActorMapper extends SearchResultMapper<Actor> {
    Actor actorAddDtoToActor(ActorAddDto actorAddDto);

    Actor actorUpdateDtoToActor(ActorUpdateDto actorUpdateDto);

    @Override
    @Mapping(target = "name", source = "value.name")
    @Mapping(target = "resultLocalId", source = "value.id")
    SearchResult toSearchResultDto(Actor value);

}
