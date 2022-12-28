package sk.vaii.sem.semestralna_praca_vaii_backend.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.entity.Role;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.repository.dao.RoleDao;

public interface RoleRepository extends JpaRepository<Role, Long>, RoleDao {}