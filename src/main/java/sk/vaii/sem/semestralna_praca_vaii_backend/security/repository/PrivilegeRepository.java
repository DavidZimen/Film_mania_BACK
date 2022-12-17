package sk.vaii.sem.semestralna_praca_vaii_backend.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.entity.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    @Query(value = "SELECT * FROM Privilege WHERE name = :privilege_name", nativeQuery = true)
    Privilege findByName(@Param("privilege_name")String name);
}