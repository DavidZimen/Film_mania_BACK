package sk.vaii.sem.film_mania_back.part_appuser.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.vaii.sem.film_mania_back.part_appuser.entities.AppUserAvatar;

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
