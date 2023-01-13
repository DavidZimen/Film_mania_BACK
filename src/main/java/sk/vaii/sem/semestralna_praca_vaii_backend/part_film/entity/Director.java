package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity;

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

    @OneToMany(mappedBy = "director")
    private List<Film> films;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_image_id", referencedColumnName = "id")
    private FilmPartImage directorImage;
}
