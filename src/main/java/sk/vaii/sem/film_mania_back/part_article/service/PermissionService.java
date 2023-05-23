package sk.vaii.sem.film_mania_back.part_article.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.vaii.sem.film_mania_back.part_security.repository.RoleRepository;
import sk.vaii.sem.film_mania_back.utils.ConstantsUtil;

@Service
@AllArgsConstructor
public class PermissionService {
    private final RoleRepository roleRepository;

    public boolean isAuthor(Long id) {
        return this.roleRepository.findUserRole(id).getName().equals(ConstantsUtil.AUTHOR_ROLE);
    }

    public boolean isAdmin(Long id) {
        return this.roleRepository.findUserRole(id).getName().equals(ConstantsUtil.ADMIN_ROLE);
    }
}
