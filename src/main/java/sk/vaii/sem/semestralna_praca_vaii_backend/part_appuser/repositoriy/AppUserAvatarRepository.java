package sk.vaii.sem.semestralna_praca_vaii_backend.part_appuser.repositoriy;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_appuser.entities.AppUserAvatar;

public interface AppUserAvatarRepository extends JpaRepository<AppUserAvatar, Long> {
    AppUserAvatar findAppUserAvatarById(Long id);
}