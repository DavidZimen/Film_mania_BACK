package sk.vaii.sem.semestralna_praca_vaii_backend.security.service;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sk.vaii.sem.semestralna_praca_vaii_backend.mapper.AppUserMapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.dto.LoggedInUserDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.dto.LoginAppUserDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.entity.AppUser;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final String USER_NOT_FOUND = "Používateľ s e-mailom %s sa nenašiel.";
    private final String WRONG_PASSWORD = "Zadané heslo nie je správne.";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AppUserMapper appUserMapper;

    @Override
    public AppUser loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email))
                );
    }

    public LoggedInUserDto logInUser(LoginAppUserDto userDto) throws UsernameNotFoundException, BadCredentialsException {
        AppUser appUser = this.loadUserByUsername(userDto.getEmail());
        if (this.passwordEncoder.matches(userDto.getPassword(), appUser.getPassword())) {
            return this.appUserMapper.appUserToLoggedInUser(appUser);
        } else {
            throw new BadCredentialsException(WRONG_PASSWORD);
        }
    }

    public LoggedInUserDto singUpUser(AppUser appUser) {
        boolean exists = this.userRepository.findByEmail(appUser.getEmail()).isPresent();

        if (exists) {
            throw new IllegalStateException("Email already exists.");
        }

        //encoding password
        String encodedPassword = this.passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        return this.appUserMapper.appUserToLoggedInUser(this.userRepository.save(appUser));
    }
}
