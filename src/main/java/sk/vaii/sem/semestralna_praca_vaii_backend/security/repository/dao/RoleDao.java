package sk.vaii.sem.semestralna_praca_vaii_backend.security.repository.dao;

import org.springframework.stereotype.Repository;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.entity.Role;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoleDao {
    Role findByName(String name);
    Role findUserRole(Long userId);
}
