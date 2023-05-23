package sk.vaii.sem.film_mania_back.part_film.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "film")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "duration", nullable = false)
    private int duration;

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(
                    name = "film_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "actor_id", referencedColumnName = "id"
            )
    )
    private List<Actor> actors;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "film_genre",
            joinColumns = @JoinColumn(
                    name = "film_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "genre_id", referencedColumnName = "id"
            )
    )
    private List<Genre> genres;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Rating> ratings;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "film_image_id", referencedColumnName = "id")
    private FilmPartImage filmImage;
}
