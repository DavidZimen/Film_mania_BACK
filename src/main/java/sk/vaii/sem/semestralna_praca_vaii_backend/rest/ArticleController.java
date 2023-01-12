package sk.vaii.sem.semestralna_praca_vaii_backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sk.vaii.sem.semestralna_praca_vaii_backend.dto.ArticleCreationDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.dto.ArticleInAuthorsListDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.dto.ArticleInMainListDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.service.ArticleService;

import java.io.IOException;
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
    public List<ArticleInMainListDto> getAllArticles() {
        return this.articleService.findAllArticles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ArticleInMainListDto>> getArticleByid(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.articleService.findArticleById(id), HttpStatus.OK);
    }

    @GetMapping("author_articles/{author_id}")
    public ResponseEntity<List<ArticleInAuthorsListDto>> getArticlesOfAuthor(@PathVariable("author_id") Long authorId){
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
