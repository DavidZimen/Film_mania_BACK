package sk.vaii.sem.semestralna_praca_vaii_backend.security.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.vaii.sem.semestralna_praca_vaii_backend.mapper.RoleMapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.dto.RoleDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.entity.Role;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.repository.RoleRepository;

import java.util.List;

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
