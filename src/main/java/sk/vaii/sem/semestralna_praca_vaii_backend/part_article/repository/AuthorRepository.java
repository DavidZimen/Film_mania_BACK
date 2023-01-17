package sk.vaii.sem.semestralna_praca_vaii_backend.part_article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_article.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}