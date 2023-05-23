package sk.vaii.sem.film_mania_back.part_security.dto;

import lombok.*;

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
    private long avatarId;
}
