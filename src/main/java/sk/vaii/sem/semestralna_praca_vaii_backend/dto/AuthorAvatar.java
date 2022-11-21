package sk.vaii.sem.semestralna_praca_vaii_backend.dto;

import lombok.Data;

@Data
public class AuthorAvatar {
    private long id;
    private String name;
    private String surname;
    private String photo;
}
