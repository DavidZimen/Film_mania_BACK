package sk.vaii.sem.semestralna_praca_vaii_backend.security.repository.dao;

import sk.vaii.sem.semestralna_praca_vaii_backend.entities.Privilege;

import java.util.List;

public interface PrivilegeDao {

    Privilege findByName(String name);

    List<Privilege> getPrivilegesOfRole(Long roleId);
}
