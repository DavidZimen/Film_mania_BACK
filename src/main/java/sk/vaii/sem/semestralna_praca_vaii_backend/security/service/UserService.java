package sk.vaii.sem.semestralna_praca_vaii_backend.security.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.entity.AppUser;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.repository.UserRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.registration.token.ConfirmationToken;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.registration.token.ConfirmationTokenService;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final String USER_NOT_FOUND = "Používateľ s e-mailom %s sa nenašiel.";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public AppUser loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email))
                );
    }

    public String singUpUser(AppUser appUser) {
        boolean exists = this.userRepository.findByEmail(appUser.getEmail()).isPresent();

        if (exists) {
            throw new IllegalStateException("Email already exists.");
        }

        //encoding password
        String encodedPassword = this.passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        this.userRepository.save(appUser);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(18),
                appUser
        );
        this.confirmationTokenService.safeConfirmationtoken(confToken);

        //TODO: send email

        return token;
    }

    public void enableAppUser(String email) {
        AppUser appUser = this.loadUserByUsername(email);
        appUser.setEnabled(true);
        this.userRepository.save(appUser);
    }
}
