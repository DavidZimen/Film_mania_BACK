package sk.vaii.sem.semestralna_praca_vaii_backend.security.repository.dao;

import org.springframework.stereotype.Repository;
import sk.vaii.sem.semestralna_praca_vaii_backend.entities.Role;

@Repository
public interface RoleDao {
    Role findByName(String name);
    Role findUserRole(Long userId);
}
