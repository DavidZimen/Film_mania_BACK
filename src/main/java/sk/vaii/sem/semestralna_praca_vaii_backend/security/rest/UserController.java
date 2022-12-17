package sk.vaii.sem.semestralna_praca_vaii_backend.security.rest;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.dto.LoginAppUserDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.entity.AppUser;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.service.UserService;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4201")
@RequestMapping("/login")
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;
    private static final Gson gson = new Gson();

    @PostMapping(value = "loginUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> loginUser(@RequestBody LoginAppUserDto userDto) {
        try {
            AppUser appUser = this.userService.loadUserByUsername(userDto.getEmail());
            if (this.passwordEncoder.matches(userDto.getPassword(), appUser.getPassword())) {
                return new ResponseEntity<>(gson.toJson(appUser.getEmail()), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
