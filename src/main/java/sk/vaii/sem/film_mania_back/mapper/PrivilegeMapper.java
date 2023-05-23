package sk.vaii.sem.film_mania_back.mapper;

import org.mapstruct.Mapper;
import sk.vaii.sem.film_mania_back.part_security.dto.PrivilegeDto;
import sk.vaii.sem.film_mania_back.part_security.entities.Privilege;

import java.util.List;

@Mapper
public interface PrivilegeMapper {
    PrivilegeDto privilegeToPrivilegeDto(Privilege privilege);

    List<PrivilegeDto> privilegeListToPrivilagesDtosList(List<Privilege> privileges);
}
