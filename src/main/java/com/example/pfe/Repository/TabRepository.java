package com.example.pfe.Repository;

import com.example.pfe.Entity.Tab;
import com.example.pfe.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TabRepository extends JpaRepository<Tab, Long> {
    boolean existsByNumber(int number);
    Optional<Tab> findById(Long idTab);

}
