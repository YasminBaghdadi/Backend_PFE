package com.example.pfe.Repository;

import com.example.pfe.Entity.Plat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlatRepository extends JpaRepository<Plat,Long> {
    Plat findByName(String name);
    Optional<Plat> findById(Long idPlat);
}
