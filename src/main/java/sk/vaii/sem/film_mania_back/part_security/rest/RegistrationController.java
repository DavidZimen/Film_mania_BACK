package sk.vaii.sem.film_mania_back.part_security.rest;

import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sk.vaii.sem.film_mania_back.part_security.dto.RegistrationRequestDto;
import sk.vaii.sem.film_mania_back.part_security.service.RegistrationService;
import sk.vaii.sem.film_mania_back.part_appuser.dto.LoggedInUserDto;

import java.io.IOException;

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
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("avatarUpload")
    public ResponseEntity<Long> uploadAvatarImage(@RequestParam("image") MultipartFile image) {
        try {
            return new ResponseEntity<>(this.registrationService.uploadAvatarImage(image), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
