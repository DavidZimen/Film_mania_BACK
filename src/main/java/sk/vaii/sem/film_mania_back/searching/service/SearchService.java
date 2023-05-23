package sk.vaii.sem.film_mania_back.searching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.vaii.sem.film_mania_back.part_film.service.ActorService;
import sk.vaii.sem.film_mania_back.part_film.service.FilmService;
import sk.vaii.sem.film_mania_back.part_film.service.DirectorService;
import sk.vaii.sem.film_mania_back.searching.dto.SearchResultDto;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SearchService {

    @Autowired
    private FilmService filmService;

    @Autowired
    private ActorService actorService;

    @Autowired
    private DirectorService directorService;

    public List<SearchResultDto> search(String query) throws ExecutionException, InterruptedException {
        CompletableFuture<List<SearchResultDto>> filmResults = CompletableFuture.supplyAsync(() -> filmService.search(query));
        CompletableFuture<List<SearchResultDto>> articleResults = CompletableFuture.supplyAsync(() -> directorService.search(query));
        CompletableFuture<List<SearchResultDto>> actorResults = CompletableFuture.supplyAsync(() -> actorService.search(query));

        return CompletableFuture
                .allOf(filmResults, actorResults, articleResults)
                .thenApplyAsync(future -> {
                    try {
                        return Stream.of(filmResults, articleResults, actorResults)
                                .map(CompletableFuture::join)
                                .flatMap(Collection::stream)
                                .collect(Collectors.toList());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .get();
    }


}
