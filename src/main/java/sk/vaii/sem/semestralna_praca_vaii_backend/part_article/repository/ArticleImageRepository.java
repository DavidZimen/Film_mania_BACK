package sk.vaii.sem.semestralna_praca_vaii_backend.part_article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_article.entity.ArticleImage;

public interface ArticleImageRepository extends JpaRepository<ArticleImage, Long> {
    ArticleImage findArticleImageById(Long id);
}