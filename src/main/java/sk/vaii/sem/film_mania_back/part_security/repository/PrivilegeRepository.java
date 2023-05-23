package sk.vaii.sem.film_mania_back.part_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.vaii.sem.film_mania_back.part_security.entities.Privilege;
import sk.vaii.sem.film_mania_back.part_security.repository.dao.PrivilegeDao;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long>, PrivilegeDao { }