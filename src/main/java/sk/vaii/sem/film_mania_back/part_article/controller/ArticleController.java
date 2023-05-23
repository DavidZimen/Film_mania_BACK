package sk.vaii.sem.film_mania_back.part_article.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sk.vaii.sem.film_mania_back.part_article.service.ArticleService;
import sk.vaii.sem.film_mania_back.part_article.service.PermissionService;
import sk.vaii.sem.film_mania_back.part_article.dto.ArticleCreationDto;
import sk.vaii.sem.film_mania_back.part_article.dto.ArticleInAuthorsListDto;
import sk.vaii.sem.film_mania_back.part_article.dto.ArticleInMainListDto;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
@CrossOrigin(origins = "http://localhost:4201")
@AllArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final PermissionService permissionService;

    private boolean isAuthor(Long id) {
        return this.permissionService.isAuthor(id) || this.permissionService.isAdmin(id);
    }

    @GetMapping("all")
    public List<ArticleInMainListDto> getAllArticles() {
        return this.articleService.findAllArticles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ArticleInMainListDto>> getArticleById(@PathVariable("id") Long id) {
        try {
            Optional<ArticleInMainListDto> article = this.articleService.findArticleById(id);
            return new ResponseEntity<>(article, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("author_articles/{author_id}")
    public ResponseEntity<List<ArticleInAuthorsListDto>> getArticlesOfAuthor(@PathVariable("author_id") Long authorId){
        if (!this.isAuthor(authorId)) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(this.articleService.findArticleByAuthorId(authorId), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public void deleteArticle(@PathVariable("id") Long id) {
        this.articleService.deleteArticle(id);
    }

    @PostMapping("add")
    public ResponseEntity<ArticleInMainListDto> addArticle(@RequestBody ArticleCreationDto articleCreation) {
        return new ResponseEntity<>(this.articleService.addArticle(articleCreation), HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<ArticleInAuthorsListDto> updateArticle(@RequestBody ArticleInAuthorsListDto article) {
        return new ResponseEntity<>(this.articleService.updateArticle(article), HttpStatus.OK);
    }

    @PostMapping("articleImageUpload")
    public ResponseEntity<Long> uploadArticleImage(@RequestParam("image") MultipartFile image) {
        try {
            return new ResponseEntity<>(this.articleService.uploadImage(image).getId(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping ("articleImageUpdate")
    ResponseEntity<Long> updateArticleImage(@RequestParam("image") MultipartFile image) {
        try {
            return new ResponseEntity<>(this.articleService.updateArticleImage(image).getId(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
