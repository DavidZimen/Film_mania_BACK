package sk.vaii.sem.film_mania_back.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sk.vaii.sem.film_mania_back.part_film.dto.DirectorAddDto;
import sk.vaii.sem.film_mania_back.part_film.dto.DirectorUpdateDto;
import sk.vaii.sem.film_mania_back.part_film.entity.Director;
import sk.vaii.sem.film_mania_back.searching.dto.SearchResultDto;
import sk.vaii.sem.film_mania_back.searching.mapper.SearchResultMapper;

import java.util.List;

@Mapper
public interface DirectorMapper extends SearchResultMapper<Director> {
    Director directorAddDtoToActor(DirectorAddDto directorAddDto);
    Director directorUpdateDtoToActor(DirectorUpdateDto directorUpdateDto);

    @Override
    @Mapping(target = "name", source = "value.name")
    @Mapping(target = "resultLocalId", source = "value.id")
    SearchResultDto toSearchResultDto(Director value);

    @Override
    List<SearchResultDto> toSearchResultDtoList(List<Director> values);
}
