package sk.vaii.sem.semestralna_praca_vaii_backend.mapper;

import org.mapstruct.Mapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.dto.PrivilegeDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.entities.Privilege;

import java.util.List;

@Mapper
public interface PrivilegeMapper {
    PrivilegeDto privilegeToPrivilegeDto(Privilege privilege);

    List<PrivilegeDto> privilegeListToPrivilagesDtosList(List<Privilege> privileges);
}
