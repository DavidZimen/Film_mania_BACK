package sk.vaii.sem.film_mania_back.part_security.repository.dao;

import org.springframework.stereotype.Repository;
import sk.vaii.sem.film_mania_back.part_security.entities.Role;

@Repository
public interface RoleDao {
    Role findByName(String name);
    Role findUserRole(Long userId);
}
