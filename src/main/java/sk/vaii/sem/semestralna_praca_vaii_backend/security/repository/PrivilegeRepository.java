package sk.vaii.sem.semestralna_praca_vaii_backend.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.entity.Privilege;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.repository.dao.PrivilegeDao;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long>, PrivilegeDao { }