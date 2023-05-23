package sk.vaii.sem.film_mania_back.part_appuser.repositoriy;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.film_mania_back.part_appuser.entities.AppUserAvatar;

public interface AppUserAvatarRepository extends JpaRepository<AppUserAvatar, Long> {
    AppUserAvatar findAppUserAvatarById(Long id);
}