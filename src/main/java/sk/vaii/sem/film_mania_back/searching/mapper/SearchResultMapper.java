package sk.vaii.sem.film_mania_back.searching.mapper;

import sk.vaii.sem.film_mania_back.searching.dto.SearchResultDto;

import java.util.List;

public interface SearchResultMapper<T> {
    SearchResultDto toSearchResultDto(T value);

    List<SearchResultDto> toSearchResultDtoList(List<T> values);
}
