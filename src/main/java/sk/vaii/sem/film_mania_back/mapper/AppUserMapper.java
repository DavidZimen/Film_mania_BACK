package sk.vaii.sem.film_mania_back.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sk.vaii.sem.film_mania_back.part_security.dto.RegistrationRequestDto;
import sk.vaii.sem.film_mania_back.part_appuser.dto.LoggedInUserDto;
import sk.vaii.sem.film_mania_back.part_appuser.entities.AppUser;
import sk.vaii.sem.film_mania_back.part_appuser.entities.AppUserAvatar;

@Mapper
public interface AppUserMapper {
    LoggedInUserDto appUserToLoggedInUser(AppUser appUser);

    @Mapping(target = "birth_date", dateFormat = "dd.MM.yyyy")
    AppUser registrationRequestToAppUser(RegistrationRequestDto requestDto);

    AppUserAvatar registrationRequestToAppUserAvatar(RegistrationRequestDto requestDto);
}
