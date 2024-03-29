package sk.vaii.sem.film_mania_back.part_film.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "film_part_image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmPartImage implements Serializable {
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
