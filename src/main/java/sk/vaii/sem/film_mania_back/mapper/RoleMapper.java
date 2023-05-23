package sk.vaii.sem.film_mania_back.mapper;

import org.mapstruct.Mapper;
import sk.vaii.sem.film_mania_back.part_security.dto.RoleDto;
import sk.vaii.sem.film_mania_back.part_security.entities.Role;

import java.util.List;

@Mapper
public interface RoleMapper {
    RoleDto roleToRoleDto(Role role);

    List<RoleDto> roleListToRoleDtoList(List<Role> roles);
}
