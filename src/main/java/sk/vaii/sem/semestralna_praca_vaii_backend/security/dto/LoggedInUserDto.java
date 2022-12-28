package sk.vaii.sem.semestralna_praca_vaii_backend.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoggedInUserDto {
    private Long id;
    private String fisrtName;
    private String lastName;
    private LocalDate birth_date;
    private String email;
    //private List<Role> roles;
}
