package sk.vaii.sem.film_mania_back.part_security.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sk.vaii.sem.film_mania_back.part_appuser.service.AppUserService;
import sk.vaii.sem.film_mania_back.mapper.AppUserMapper;
import sk.vaii.sem.film_mania_back.part_appuser.dto.LoggedInUserDto;
import sk.vaii.sem.film_mania_back.part_security.dto.RegistrationRequestDto;
import sk.vaii.sem.film_mania_back.part_security.email.EmailValidator;
import sk.vaii.sem.film_mania_back.part_appuser.entities.AppUser;

import java.io.IOException;
import java.util.Arrays;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserService appUserService;
    private final RoleService roleService;
    private final AppUserMapper appUserMapper;

    @Transactional
    public LoggedInUserDto registerNewUser(RegistrationRequestDto request) {
        boolean isEmailValid = this.emailValidator.test(request.getEmail());

        if (!isEmailValid)
            throw new IllegalStateException("Email is not valid");

        AppUser appUser = this.appUserMapper.registrationRequestToAppUser(request);
        appUser.setRoles(Arrays.asList(this.roleService.findRoleByName(request.getRole())));

        return this.appUserService.singUpUser(appUser, request.getAvatarId());
    }

    @Transactional
    public long uploadAvatarImage(MultipartFile avatarImage) throws IOException {
        return this.appUserService.uploadAvatar(avatarImage).getId();
    }
}
