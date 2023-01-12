package sk.vaii.sem.semestralna_praca_vaii_backend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.vaii.sem.semestralna_praca_vaii_backend.entities.AppUserAvatar;
import sk.vaii.sem.semestralna_praca_vaii_backend.repository.AppUserAvatarRepository;

@Service
@AllArgsConstructor
public class AppUserAvatarService {
    private final AppUserAvatarRepository appUserAvatarRepository;

    public AppUserAvatar getAvatar(Long id) {
        return this.appUserAvatarRepository.findAppUserAvatarById(id);
    }
}
