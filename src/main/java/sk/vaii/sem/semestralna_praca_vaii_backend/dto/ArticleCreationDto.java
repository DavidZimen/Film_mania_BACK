package sk.vaii.sem.semestralna_praca_vaii_backend.dto;

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
