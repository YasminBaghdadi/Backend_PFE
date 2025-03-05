package com.example.pfe.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

import java.util.HashSet;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@Table(name = "tab")  // Le nom de la table, attention à ne pas utiliser le mot réservé "table"
@Data
public class Tab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTable;

    private int number;



    @OneToMany(mappedBy = "tab", cascade = CascadeType.ALL)
    private Set<Commande> commandes = new HashSet<>();

    @OneToOne(mappedBy = "tab", cascade = CascadeType.ALL)
    private QRcode qrcode;
}
