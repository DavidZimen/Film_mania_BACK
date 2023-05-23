package sk.vaii.sem.film_mania_back.part_article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.film_mania_back.part_article.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}