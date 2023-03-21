package sk.vaii.sem.semestralna_praca_vaii_backend.searching.mapper;

import sk.vaii.sem.semestralna_praca_vaii_backend.searching.dto.SearchResultDto;

import java.util.List;

public interface SearchResultMapper<T> {
    SearchResultDto toSearchResultDto(T value);

    List<SearchResultDto> toSearchResultDtoList(List<T> values);
}
