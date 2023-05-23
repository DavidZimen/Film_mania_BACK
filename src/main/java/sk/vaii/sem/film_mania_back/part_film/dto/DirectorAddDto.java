package sk.vaii.sem.film_mania_back.part_film.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DirectorAddDto {
    private String name;
    private String description;
    private Long image_id;
}