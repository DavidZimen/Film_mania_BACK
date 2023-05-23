package sk.vaii.sem.film_mania_back.part_appuser.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.vaii.sem.film_mania_back.part_appuser.entities.AppUserAvatar;
import sk.vaii.sem.film_mania_back.part_appuser.repositoriy.AppUserAvatarRepository;

@Service
@AllArgsConstructor
public class AppUserAvatarService {
    private final AppUserAvatarRepository appUserAvatarRepository;

    public AppUserAvatar getAvatar(Long id) {
        return this.appUserAvatarRepository.findAppUserAvatarById(id);
    }
}
