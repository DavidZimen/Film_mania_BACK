package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_article.entity.Article;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "director")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @OneToMany(mappedBy = "director")
    @JsonIgnore
    private List<Film> films;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_image_id", referencedColumnName = "id")
    private FilmPartImage directorImage;
}
