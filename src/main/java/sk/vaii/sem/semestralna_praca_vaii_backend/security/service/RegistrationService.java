package sk.vaii.sem.semestralna_praca_vaii_backend.security.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.vaii.sem.semestralna_praca_vaii_backend.mapper.AppUserMapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.dto.LoggedInUserDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.dto.RegistrationRequestDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.email.EmailValidator;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.entity.AppUser;

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

        return this.appUserService.singUpUser(appUser);
    }
}
