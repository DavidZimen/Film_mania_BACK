package sk.vaii.sem.semestralna_praca_vaii_backend.security.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfTokenRepository confirmationTokenRepository;

    public void safeConfirmationtoken(ConfirmationToken token) {
        this.confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return this.confirmationTokenRepository.findByToken(token);
    }

    public void setConfirmedAt(String token) {
        //validation of existing is done before calling this method, so it is not needed
        ConfirmationToken confToken = this.getToken(token)
                .orElseThrow(() ->new IllegalStateException("Token does not exists"));
        confToken.setConfirmedAt(LocalDateTime.now());
        this.confirmationTokenRepository.save(confToken);
    }
}
