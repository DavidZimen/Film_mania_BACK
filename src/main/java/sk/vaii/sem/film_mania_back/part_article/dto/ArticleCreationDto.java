package sk.vaii.sem.film_mania_back.part_article.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArticleCreationDto {
    private String title;
    private String text;
    private String author_email;
    private Long image_id;
}
