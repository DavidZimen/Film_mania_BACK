package sk.vaii.sem.semestralna_praca_vaii_backend.part_article.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.vaii.sem.semestralna_praca_vaii_backend.utils.ConstantsUtil;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_security.repository.RoleRepository;

@Service
@AllArgsConstructor
public class PermissionService {
    private final RoleRepository roleRepository;

    public boolean isAuthor(Long id) {
        return this.roleRepository.findUserRole(id).getName().equals(ConstantsUtil.AUTHOR_ROLE);
    }
}
