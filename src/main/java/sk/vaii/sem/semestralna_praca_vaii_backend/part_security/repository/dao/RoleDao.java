package sk.vaii.sem.semestralna_praca_vaii_backend.part_security.repository.dao;

import org.springframework.stereotype.Repository;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_security.entities.Role;

@Repository
public interface RoleDao {
    Role findByName(String name);
    Role findUserRole(Long userId);
}
