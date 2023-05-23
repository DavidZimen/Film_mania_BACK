package sk.vaii.sem.film_mania_back.part_article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.film_mania_back.part_article.entity.ArticleImage;

public interface ArticleImageRepository extends JpaRepository<ArticleImage, Long> {
    ArticleImage findArticleImageById(Long id);
}