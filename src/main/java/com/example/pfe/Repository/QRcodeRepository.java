package com.example.pfe.Repository;

import com.example.pfe.Entity.QRcode;
import com.example.pfe.Entity.Tab;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QRcodeRepository extends JpaRepository<QRcode, String> {
    Optional<QRcode> findByTab(Tab tab);
}
