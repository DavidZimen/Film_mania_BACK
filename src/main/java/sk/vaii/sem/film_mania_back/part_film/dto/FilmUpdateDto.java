package sk.vaii.sem.film_mania_back.part_film.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.vaii.sem.film_mania_back.part_film.entity.FilmPartImage;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilmUpdateDto {
    private Long id;
    private String title;
    private String description;
    private int year;
    private int duration;
    private Long directorId;
    private FilmPartImage image_id;
    private List<Long> actorIds;
    private List<Long> genreIds;
}