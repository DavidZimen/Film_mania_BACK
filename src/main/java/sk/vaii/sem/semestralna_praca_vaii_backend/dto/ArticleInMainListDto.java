package sk.vaii.sem.semestralna_praca_vaii_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.vaii.sem.semestralna_praca_vaii_backend.entities.ArticleImage;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArticleInMainListDto {
    private Long id;
    private String title;
    private String text;
    private ArticleImage articleImage;
    private String fisrtName;
    private String lastName;
    private byte[] avatar;
}
