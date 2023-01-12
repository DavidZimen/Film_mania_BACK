package sk.vaii.sem.semestralna_praca_vaii_backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sk.vaii.sem.semestralna_praca_vaii_backend.dto.ArticleCreationDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.dto.ArticleInAuthorsListDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.dto.ArticleInMainListDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.entities.Article;

import java.util.List;

@Mapper
public interface ArticleMapper {
    Article articleCreationToArticle(ArticleCreationDto articleCreation);

    @Mapping(source = "author.fisrtName", target = "fisrtName")
    @Mapping(source = "author.lastName", target = "lastName")
    @Mapping(source = "author.avatar.avatarData", target = "avatar")
    ArticleInMainListDto articleToArticleInListDto(Article article);

    List<ArticleInMainListDto> articlesToArticleInMainListDtos(List<Article> articles);

    ArticleInAuthorsListDto articleToArticleInAuthorListDto(Article article);

    List<ArticleInAuthorsListDto> articlesToArticleInAuthorListDtos(List<Article> articles);
}
