package sk.vaii.sem.semestralna_praca_vaii_backend.part_film.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_appuser.entities.AppUser;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "actor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "actor_image_id", referencedColumnName = "id")
    private FilmPartImage actorImage;

    @ManyToMany(mappedBy = "actors")
    @JsonIgnore
    private List<Film> films;
}
