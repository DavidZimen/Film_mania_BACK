package sk.vaii.sem.film_mania_back.part_article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.film_mania_back.part_appuser.entities.AppUser;
import sk.vaii.sem.film_mania_back.part_article.entity.Article;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findArticlesByAuthor(AppUser appUser);
}