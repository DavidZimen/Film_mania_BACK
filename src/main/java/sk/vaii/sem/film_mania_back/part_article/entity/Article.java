package sk.vaii.sem.film_mania_back.part_article.entity;

import lombok.*;
import sk.vaii.sem.film_mania_back.part_appuser.entities.AppUser;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "article")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "text", columnDefinition = "TEXT", nullable = false)
    private String text;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "article_image_id", referencedColumnName = "id")
    private ArticleImage articleImage;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private AppUser author;
}
