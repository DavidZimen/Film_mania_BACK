package sk.vaii.sem.semestralna_praca_vaii_backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sk.vaii.sem.semestralna_praca_vaii_backend.dto.LoggedInUserDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.dto.RegistrationRequestDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.entities.AppUser;
import sk.vaii.sem.semestralna_praca_vaii_backend.entities.AppUserAvatar;

@Mapper
public interface AppUserMapper {
    LoggedInUserDto appUserToLoggedInUser(AppUser appUser);

    @Mapping(target = "birth_date", dateFormat = "dd.MM.yyyy")
    AppUser registrationRequestToAppUser(RegistrationRequestDto requestDto);

    AppUserAvatar registrationRequestToAppUserAvatar(RegistrationRequestDto requestDto);
}
