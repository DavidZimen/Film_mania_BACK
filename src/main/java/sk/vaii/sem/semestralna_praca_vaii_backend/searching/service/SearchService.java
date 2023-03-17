package sk.vaii.sem.semestralna_praca_vaii_backend.searching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_article.service.ArticleService;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.service.ActorService;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.service.FilmService;
import sk.vaii.sem.semestralna_praca_vaii_backend.searching.dto.SearchResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class SearchService {

    @Autowired
    private FilmService filmService;

    @Autowired
    private ActorService actorService;

    @Autowired
    private ArticleService articleService;

    public List<SearchResultDto> search(String query) throws ExecutionException, InterruptedException {
        CompletableFuture<List<SearchResultDto>> filmResults = CompletableFuture.supplyAsync(() -> filmService.search(query));
        CompletableFuture<List<SearchResultDto>> articleResults = CompletableFuture.supplyAsync(() -> articleService.search(query));
        CompletableFuture<List<SearchResultDto>> actorResults = CompletableFuture.supplyAsync(() -> actorService.search(query));

        return CompletableFuture
                .allOf(filmResults, actorResults, articleResults)
                .thenApplyAsync(v -> {
                    try {
                        List<SearchResultDto> results = new ArrayList<>();

                        results.addAll(filmResults.get());
                        results.addAll(actorResults.get());
                        results.addAll(articleResults.get());
;
                        return results;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .get();
    }


}
