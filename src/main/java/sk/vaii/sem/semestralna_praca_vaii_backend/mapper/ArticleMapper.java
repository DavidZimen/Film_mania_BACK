package sk.vaii.sem.semestralna_praca_vaii_backend.mapper;

import org.mapstruct.Mapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.dto.ArticleCreation;
import sk.vaii.sem.semestralna_praca_vaii_backend.entities.Article;

@Mapper
public interface ArticleMapper {
    Article articleCreationToArticle(ArticleCreation articleCreation);
}
