package sk.vaii.sem.semestralna_praca_vaii_backend.security.repository.dao;

import org.springframework.data.repository.query.Param;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.entity.Privilege;

import java.util.List;
import java.util.Optional;

public interface PrivilegeDao {

    Privilege findByName(String name);

    List<Privilege> getPrivilegesOfRole(Long roleId);
}
