package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "film_part_image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmPartImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "film_part_image", nullable = false)
    private byte[] image;

    @OneToOne(mappedBy = "filmImage")
    @JsonIgnore
    private Film film;

    @OneToOne(mappedBy = "actorImage")
    @JsonIgnore
    private Actor actor;

    @OneToOne(mappedBy = "directorImage")
    @JsonIgnore
    private Director director;
}
