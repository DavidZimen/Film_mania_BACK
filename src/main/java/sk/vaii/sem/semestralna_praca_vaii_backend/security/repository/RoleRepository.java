package sk.vaii.sem.semestralna_praca_vaii_backend.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sk.vaii.sem.semestralna_praca_vaii_backend.security.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(value = "SELECT * FROM Role WHERE name = :role_name", nativeQuery = true)
    Role findByName(@Param("role_name")String name);
}