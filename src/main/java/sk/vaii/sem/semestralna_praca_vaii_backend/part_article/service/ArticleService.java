package sk.vaii.sem.semestralna_praca_vaii_backend.part_article.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_article.dto.ArticleCreationDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_article.dto.ArticleInAuthorsListDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_article.dto.ArticleInMainListDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_appuser.entities.AppUser;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_article.entity.Article;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_article.entity.ArticleImage;
import sk.vaii.sem.semestralna_praca_vaii_backend.mapper.ArticleMapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_article.repository.ArticleImageRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_article.repository.ArticleRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_appuser.service.AppUserService;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleImageRepository articleImageRepository;

    private final AppUserService appUserService;

    private final ArticleMapper articleMapper;

    public List<ArticleInMainListDto> findAllArticles() {
        return this.articleMapper.articlesToArticleInMainListDtos(this.articleRepository.findAll());
    }

    public Optional<ArticleInMainListDto> findArticleById(Long id) {
        return Optional.ofNullable(this.articleMapper.articleToArticleInListDto(this.articleRepository.findById(id).get()));
    }

    @Transactional
    public List<ArticleInAuthorsListDto> findArticleByAuthorId(Long authorId) {
        AppUser appUser = this.appUserService.loadUserById(authorId);
        return this.articleMapper.articlesToArticleInAuthorListDtos(this.articleRepository.findArticlesByAuthor(appUser));
    }

    @Transactional
    public ArticleInMainListDto addArticle(ArticleCreationDto articleCreation) {
        Article article = this.articleMapper.articleCreationToArticle(articleCreation);

        //find image to the article
        ArticleImage image = this.articleImageRepository.findArticleImageById(articleCreation.getImage_id());
        article.setArticleImage(image);

        //find author of the article
        AppUser author = this.appUserService.loadUserByUsername(articleCreation.getAuthor_email());
        article.setAuthor(author);

        return this.articleMapper.articleToArticleInListDto(this.articleRepository.save(article));
    }

    @Transactional
    public ArticleInAuthorsListDto updateArticle(ArticleInAuthorsListDto articleInAuthorsListDto) {
        Article article = this.articleRepository.getById(articleInAuthorsListDto.getId());

        article.setTitle(articleInAuthorsListDto.getTitle());
        article.setText(articleInAuthorsListDto.getText());

        return this.articleMapper.articleToArticleInAuthorListDto(this.articleRepository.save(article));
    }

    @Transactional
    public void deleteArticle(Long id) {
        this.articleRepository.deleteById(id);
    }

    @Transactional
    public ArticleImage uploadImage(MultipartFile image) throws IOException {
        ArticleImage articleImage = new ArticleImage();
        articleImage.setImage(image.getBytes());

        return this.articleImageRepository.save(articleImage);
    }

    @Transactional
    public ArticleImage updateArticleImage(MultipartFile image) throws IOException {
        if (image.getName().equals("image")) {
            return this.uploadImage(image);
        }

        ArticleImage articleImage = this.articleImageRepository.getById(Long.parseLong(image.getName()));
        articleImage.setImage(image.getBytes());

        return this.articleImageRepository.save(articleImage);
    }
}
