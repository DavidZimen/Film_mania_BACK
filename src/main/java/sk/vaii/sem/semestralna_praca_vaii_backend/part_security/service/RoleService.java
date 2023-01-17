package sk.vaii.sem.semestralna_praca_vaii_backend.part_security.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.vaii.sem.semestralna_praca_vaii_backend.mapper.RoleMapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_security.dto.RoleDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_security.entities.Role;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_security.repository.RoleRepository;

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
