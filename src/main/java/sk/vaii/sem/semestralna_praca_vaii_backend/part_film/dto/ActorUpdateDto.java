package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity.FilmPartImage;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActorUpdateDto {
    private Long id;
    private String name;
    private String description;
    private FilmPartImage image_id;
}