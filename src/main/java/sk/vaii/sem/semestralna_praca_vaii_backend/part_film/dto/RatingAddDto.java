package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RatingAddDto {
    private int rating;
    private Long userId;
    private Long filmId;
}
