package sk.vaii.sem.film_mania_back.part_security.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.vaii.sem.film_mania_back.mapper.PrivilegeMapper;
import sk.vaii.sem.film_mania_back.part_security.dto.PrivilegeDto;
import sk.vaii.sem.film_mania_back.part_security.repository.PrivilegeRepository;

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
