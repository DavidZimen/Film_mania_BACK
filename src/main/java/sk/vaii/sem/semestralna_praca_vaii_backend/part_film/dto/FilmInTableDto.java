package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilmInTableDto {
    private Long id;
    private String title;
    private int duration;
    private int year;
    private double overallRating;
    private Long ratingId;
    private int userRating;
}
