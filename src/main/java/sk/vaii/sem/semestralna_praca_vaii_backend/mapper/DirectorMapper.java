package sk.vaii.sem.semestralna_praca_vaii_backend.mapper;

import com.scheidtbachmann.ps.search.searchextension.dto.SearchResult;
import com.scheidtbachmann.ps.search.searchextension.mapper.SearchResultMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.DirectorAddDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.DirectorUpdateDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Director;

import java.util.List;

@Mapper
public interface DirectorMapper extends SearchResultMapper<Director> {
    Director directorAddDtoToActor(DirectorAddDto directorAddDto);
    Director directorUpdateDtoToActor(DirectorUpdateDto directorUpdateDto);

    @Override
    @Mapping(target = "name", source = "value.name")
    @Mapping(target = "resultLocalId", source = "value.id")
    SearchResult toSearchResultDto(Director value);
}
