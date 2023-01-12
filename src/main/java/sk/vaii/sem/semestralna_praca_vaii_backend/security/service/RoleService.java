package sk.vaii.sem.semestralna_praca_vaii_backend.security.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.vaii.sem.semestralna_praca_vaii_backend.mapper.RoleMapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.dto.RoleDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.entities.Role;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.repository.RoleRepository;

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
