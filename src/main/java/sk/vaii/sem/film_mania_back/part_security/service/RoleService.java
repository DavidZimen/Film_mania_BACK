package sk.vaii.sem.film_mania_back.part_security.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.vaii.sem.film_mania_back.part_security.entities.Role;
import sk.vaii.sem.film_mania_back.part_security.repository.RoleRepository;
import sk.vaii.sem.film_mania_back.mapper.RoleMapper;
import sk.vaii.sem.film_mania_back.part_security.dto.RoleDto;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public Role findRoleByName(String name) {
        return this.roleRepository.findByName(name);
    }

    public RoleDto getUserRoles(Long userId) {
        return this.roleMapper.roleToRoleDto(this.roleRepository.findUserRole(userId));
    }
}
