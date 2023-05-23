package sk.vaii.sem.film_mania_back.part_security.repository.dao;

import sk.vaii.sem.film_mania_back.part_security.entities.Privilege;

import java.util.List;

public interface PrivilegeDao {

    Privilege findByName(String name);

    List<Privilege> getPrivilegesOfRole(Long roleId);
}
