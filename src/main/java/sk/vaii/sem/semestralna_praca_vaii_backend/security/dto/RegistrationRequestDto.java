package sk.vaii.sem.semestralna_praca_vaii_backend.security.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class RegistrationRequestDto {
    private String fisrtName;
    private String lastName;
    private String password;
    private String email;
    private String birth_date;
    private String role;
}
