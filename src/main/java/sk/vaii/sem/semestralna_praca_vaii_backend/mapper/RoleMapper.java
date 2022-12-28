package sk.vaii.sem.semestralna_praca_vaii_backend.mapper;

import org.mapstruct.Mapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.dto.RoleDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.entity.Role;

import java.util.List;

@Mapper
public interface RoleMapper {
    RoleDto roleToRoleDto(Role role);

    List<RoleDto> roleListToRoleDtoList(List<Role> roles);
}
