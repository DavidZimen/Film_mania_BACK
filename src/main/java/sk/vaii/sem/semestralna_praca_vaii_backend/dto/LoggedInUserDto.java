package sk.vaii.sem.semestralna_praca_vaii_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.vaii.sem.semestralna_praca_vaii_backend.entities.AppUserAvatar;

import java.time.LocalDate;

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
    private AppUserAvatar avatar;
}
