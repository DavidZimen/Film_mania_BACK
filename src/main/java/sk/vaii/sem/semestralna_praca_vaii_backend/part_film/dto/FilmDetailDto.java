package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FilmDetailDto {
    private Long id;
    private String title;
    private int duration;
    private int year;
    private String description;
    private double overallRating;
    private Long ratingId;
    private int userRating;
}
