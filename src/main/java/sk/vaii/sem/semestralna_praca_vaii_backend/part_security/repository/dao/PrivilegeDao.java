package sk.vaii.sem.semestralna_praca_vaii_backend.part_security.repository.dao;

import sk.vaii.sem.semestralna_praca_vaii_backend.part_security.entities.Privilege;

import java.util.List;

public interface PrivilegeDao {

    Privilege findByName(String name);

    List<Privilege> getPrivilegesOfRole(Long roleId);
}
