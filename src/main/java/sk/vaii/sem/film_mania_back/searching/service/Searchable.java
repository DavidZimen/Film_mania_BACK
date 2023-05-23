package sk.vaii.sem.film_mania_back.searching.service;

import sk.vaii.sem.film_mania_back.searching.dto.SearchResultDto;

import java.util.List;

public interface Searchable {
    List<SearchResultDto> search(String query);
}
