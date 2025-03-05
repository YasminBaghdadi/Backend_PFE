package com.example.pfe.Repository;

import com.example.pfe.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findById(Long idUser);
}
