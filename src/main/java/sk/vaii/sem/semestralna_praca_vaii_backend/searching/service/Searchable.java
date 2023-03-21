package sk.vaii.sem.semestralna_praca_vaii_backend.searching.service;

import sk.vaii.sem.semestralna_praca_vaii_backend.searching.dto.SearchResultDto;

import java.util.List;

public interface Searchable {
    List<SearchResultDto> search(String query);
}
