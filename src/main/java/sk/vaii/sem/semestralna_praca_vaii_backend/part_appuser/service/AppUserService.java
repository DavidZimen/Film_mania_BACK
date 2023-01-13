package sk.vaii.sem.semestralna_praca_vaii_backend.part_appuser.service;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_appuser.entities.AppUserAvatar;
import sk.vaii.sem.semestralna_praca_vaii_backend.mapper.AppUserMapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_appuser.dto.LoggedInUserDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_appuser.dto.LoginAppUserDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_appuser.entities.AppUser;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_appuser.repositoriy.AppUserAvatarRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_appuser.repositoriy.AppUserRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.utils.ImageUtil;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final String USER_NOT_FOUND = "Používateľ s e-mailom %s sa nenašiel.";
    private final String WRONG_PASSWORD = "Zadané heslo nie je správne.";
    private final AppUserRepository appUserRepository;
    private final AppUserAvatarRepository appUserAvatarRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AppUserMapper appUserMapper;

    @Override
    @Transactional
    public AppUser loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.appUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email))
                );
    }

    @Transactional
    public AppUser loadUserById(Long id) {
        return this.appUserRepository.getById(id);
    }

    @Transactional
    public LoggedInUserDto logInUser(LoginAppUserDto userDto) throws UsernameNotFoundException, BadCredentialsException {
        AppUser appUser = this.loadUserByUsername(userDto.getEmail());
        if (this.passwordEncoder.matches(userDto.getPassword(), appUser.getPassword())) {
            return this.appUserMapper.appUserToLoggedInUser(appUser);
        } else {
            throw new BadCredentialsException(WRONG_PASSWORD);
        }
    }

    @Transactional
    public LoggedInUserDto singUpUser(AppUser appUser, Long avatarId) {
        boolean exists = this.appUserRepository.findByEmail(appUser.getEmail()).isPresent();

        if (exists) {
            throw new IllegalStateException("Email already exists.");
        }

        //encoding password
        String encodedPassword = this.passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        AppUserAvatar appUserAvatar = this.appUserAvatarRepository.findAppUserAvatarById(avatarId);
        appUser.setAvatar(appUserAvatar);

        AppUser registeredAppUser = this.appUserRepository.save(appUser);
        registeredAppUser.getAvatar().setAvatarData(ImageUtil.decompressImage(registeredAppUser.getAvatar().getAvatarData()));

        return this.appUserMapper.appUserToLoggedInUser(registeredAppUser);
    }

    @Transactional
    public AppUserAvatar uploadAvatar(MultipartFile image) throws IOException {
        AppUserAvatar avatar = new AppUserAvatar();
        avatar.setAvatarData(ImageUtil.compressImage(image.getBytes()));

        return this.appUserAvatarRepository.save(avatar);
    }
}
