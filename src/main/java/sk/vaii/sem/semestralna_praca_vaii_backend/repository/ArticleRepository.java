package sk.vaii.sem.semestralna_praca_vaii_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}