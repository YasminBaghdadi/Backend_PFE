package com.example.pfe.Repository;

import com.example.pfe.Entity.Role;
import com.example.pfe.Entity.Rolename;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRolename(Rolename rolename);
}
