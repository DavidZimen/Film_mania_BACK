package sk.vaii.sem.film_mania_back.part_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.film_mania_back.part_security.entities.Role;
import sk.vaii.sem.film_mania_back.part_security.repository.dao.RoleDao;

public interface RoleRepository extends JpaRepository<Role, Long>, RoleDao {}