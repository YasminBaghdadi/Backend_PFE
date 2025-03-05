package com.example.pfe.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
@Data
@Getter
@Setter


public class Plat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPlat;

    private String name;
    private String description;
    private double prix;

    @ManyToMany(mappedBy = "plats")
    private Set<Commande> commandes = new HashSet<>();

    @OneToOne
    private Image imagePlat;

}


