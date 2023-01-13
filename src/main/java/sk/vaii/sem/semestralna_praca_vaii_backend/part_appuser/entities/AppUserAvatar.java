package sk.vaii.sem.semestralna_praca_vaii_backend.part_appuser.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "app_user_avatar")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUserAvatar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "avatar_data", nullable = false)
    private byte[] avatarData;

    @OneToOne(mappedBy = "avatar")
    @JsonIgnore
    private AppUser appUser;
}
