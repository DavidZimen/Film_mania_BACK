package sk.vaii.sem.semestralna_praca_vaii_backend.part_appuser.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_article.entity.Article;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_security.entities.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@NoArgsConstructor
public class AppUser implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fisrtName;
    private String lastName;
    private LocalDate birth_date;
    @Column(unique = true)
    private String email;
    private String password;
    private Boolean locked = false;
    private Boolean enabled = true ;

    @ManyToMany
    @JoinTable(
            name = "role_app_user",
            joinColumns = @JoinColumn(
                    name = "app_user_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"
            )
    )
    private List<Role> roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "avatar_id", referencedColumnName = "id")
    private AppUserAvatar avatar;

    @OneToMany(mappedBy = "author")
    private List<Article> article;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
