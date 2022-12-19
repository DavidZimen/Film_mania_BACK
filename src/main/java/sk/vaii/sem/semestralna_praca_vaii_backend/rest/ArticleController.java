package sk.vaii.sem.semestralna_praca_vaii_backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.vaii.sem.semestralna_praca_vaii_backend.dto.ArticleCreation;
import sk.vaii.sem.semestralna_praca_vaii_backend.entities.Article;
import sk.vaii.sem.semestralna_praca_vaii_backend.service.ArticleService;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
@CrossOrigin(origins = "http://localhost:4201")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("all")
    public List<Article> getAllArticles() {
        return this.articleService.findAllArticles();
    }

    @GetMapping("/{id}")
    public Optional<Article> getArticleByid(@PathVariable("id") Long id) {
        return this.articleService.findArticleById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteArticle(@PathVariable("id") Long id) {
        this.articleService.deleteArticle(id);
    }

    @PostMapping("add")
    public Article addArticle(@RequestBody ArticleCreation articleCreation) {
        //TODO implement mapper
        return this.articleService.addArticle(articleCreation);
    }

    @PutMapping("update")
    public Article updateArticle(@RequestBody Article article) {
        return this.articleService.updateArticle(article);
    }
}
