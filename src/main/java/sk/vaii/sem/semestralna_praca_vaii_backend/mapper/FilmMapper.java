package sk.vaii.sem.semestralna_praca_vaii_backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.FilmAddDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.FilmDetailDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.FilmInTableDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto.FilmUpdateDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.Film;
import sk.vaii.sem.semestralna_praca_vaii_backend.searching.dto.SearchResultDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.searching.mapper.SearchResultMapper;

import java.util.List;

@Mapper
public interface FilmMapper extends SearchResultMapper<Film> {
    Film filmAddDtotoFilm(FilmAddDto filmAddDto);
    Film filmUpdateDtoToFilm(FilmUpdateDto filmUpdateDto);

    FilmAddDto filmToFilmAddDto(Film film);

    FilmInTableDto filmToFilmInTableDto(Film film);

    FilmDetailDto filmToFilmDetailDto(Film film);

    List<FilmInTableDto> filmsToFilmInTableDtos(List<Film> films);

    @Override
    @Mapping(target = "name", source = "value.title")
    @Mapping(target = "resultLocalId", source = "value.id")
    SearchResultDto toSearchResultDto(Film value);

    @Override
    List<SearchResultDto> toSearchResultDtoList(List<Film> values);
}
