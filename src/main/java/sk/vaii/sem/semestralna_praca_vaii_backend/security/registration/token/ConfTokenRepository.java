package sk.vaii.sem.semestralna_praca_vaii_backend.security.registration.token;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfTokenRepository extends JpaRepository<ConfirmationToken, Long> {
    Optional<ConfirmationToken> findByToken(String token);
}