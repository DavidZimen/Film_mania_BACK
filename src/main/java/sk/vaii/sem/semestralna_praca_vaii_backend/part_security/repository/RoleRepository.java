package sk.vaii.sem.semestralna_praca_vaii_backend.part_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_security.entities.Role;
import sk.vaii.sem.semestralna_praca_vaii_backend.part_security.repository.dao.RoleDao;

public interface RoleRepository extends JpaRepository<Role, Long>, RoleDao {}