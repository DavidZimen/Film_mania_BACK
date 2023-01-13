package sk.vaii.sem.semestralna_praca_vaii_backend.part_appuser.dto;

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
