package sk.vaii.sem.semestralna_praca_vaii_backend.security.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.vaii.sem.semestralna_praca_vaii_backend.mapper.PrivilegeMapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.dto.PrivilegeDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.repository.PrivilegeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PrivilegeService {

    private final PrivilegeRepository privilegeRepository;
    private final PrivilegeMapper privilegeMapper;

    public List<PrivilegeDto> getPrivilegesOfRole(Long roleId) {
        return this.privilegeMapper.privilegeListToPrivilagesDtosList(
                this.privilegeRepository.getPrivilegesOfRole(roleId)
        );
    }
}
