package sk.vaii.sem.film_mania_back.part_appuser.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginAppUserDto {
    private String email;
    private String password;
}
