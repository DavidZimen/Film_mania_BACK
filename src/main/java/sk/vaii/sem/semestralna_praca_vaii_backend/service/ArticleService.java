package sk.vaii.sem.semestralna_praca_vaii_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.vaii.sem.semestralna_praca_vaii_backend.entities.Article;
import sk.vaii.sem.semestralna_praca_vaii_backend.repository.ArticleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> findAllArticles() {
        return this.articleRepository.findAll();
    }

    public Optional<Article> findArticleById(Long id) {
        return this.articleRepository.findById(id);
    }

    public Article addArticle(Article article) {
        return this.articleRepository.save(article);
    }

    public Article updateArticle(Article article) {
        return this.articleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        this.articleRepository.deleteById(id);
    }
}
