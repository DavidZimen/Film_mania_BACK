package sk.vaii.sem.semestralna_praca_vaii_backend.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.semestralna_praca_vaii_backend.entities.Privilege;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.repository.dao.PrivilegeDao;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long>, PrivilegeDao { }