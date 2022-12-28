package sk.vaii.sem.semestralna_praca_vaii_backend.security.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.dto.LoggedInUserDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.dto.RegistrationRequestDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.service.RegistrationService;

@RestController
@RequestMapping(path = "registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<LoggedInUserDto> register(@RequestBody RegistrationRequestDto requestDto) {
        try {
            return new ResponseEntity<>(this.registrationService.registerNewUser(requestDto), HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
