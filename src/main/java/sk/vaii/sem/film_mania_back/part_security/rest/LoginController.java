package sk.vaii.sem.film_mania_back.part_security.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import sk.vaii.sem.film_mania_back.part_appuser.dto.LoggedInUserDto;
import sk.vaii.sem.film_mania_back.part_appuser.dto.LoginAppUserDto;
import sk.vaii.sem.film_mania_back.part_appuser.service.AppUserService;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4201")
@RequestMapping("/login")
public class LoginController {

    private final AppUserService appUserService;

    @PostMapping(value = "loginUser")
    public ResponseEntity<LoggedInUserDto> loginUser(@RequestBody LoginAppUserDto userDto) {
        try {
            LoggedInUserDto loggedInUserDto = this.appUserService.logInUser(userDto);
            return new ResponseEntity<>(loggedInUserDto, HttpStatus.OK);
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    
}
