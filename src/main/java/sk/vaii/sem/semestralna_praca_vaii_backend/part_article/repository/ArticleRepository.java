package sk.vaii.sem.semestralna_praca_vaii_backend.part_article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_appuser.entities.AppUser;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_article.entity.Article;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findArticlesByAuthor(AppUser appUser);
}