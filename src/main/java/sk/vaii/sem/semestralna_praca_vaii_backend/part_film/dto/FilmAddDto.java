package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilmAddDto {
    private String title;
    private String description;
    private int year;
    private int duration;
    private String directorName;
    private List<String> actorNames;
    private List<String> genreNames;
}
