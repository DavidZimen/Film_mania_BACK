package sk.vaii.sem.semestralna_praca_vaii_backend.mapper;

import org.mapstruct.Mapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.dto.LoggedInUser;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.entity.AppUser;

@Mapper
public interface AppUserMapper {
    LoggedInUser appUserToLoggedInUser(AppUser appUser);
}
