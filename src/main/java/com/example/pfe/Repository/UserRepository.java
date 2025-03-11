package com.example.pfe.Repository;

import com.example.pfe.Entity.Rolename;
import com.example.pfe.Entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    User findByUsername (String username) ;
    Optional<User> findById(Long idUser);
}
