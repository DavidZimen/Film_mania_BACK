package sk.vaii.sem.semestralna_praca_vaii_backend.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.entity.Role;

import java.util.Collection;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoggedInUser {
    private Long id;
    private String fisrtName;
    private String lastName;
    private Date birth_date;
    private String email;
    private Collection<Role> roles;
}
