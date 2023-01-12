package sk.vaii.sem.semestralna_praca_vaii_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "article_image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleImage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "article_image", nullable = false)
    private byte[] image;

    @OneToOne(mappedBy = "articleImage")
    @JsonIgnore
    private Article article;
}
