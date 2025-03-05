package com.example.pfe.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.util.List;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Data
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCmnd;

    @Setter
    private double total;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(
            name = "commande_plat",
            joinColumns = @JoinColumn(name = "idCmnd"),
            inverseJoinColumns = @JoinColumn(name = "idPlat")
    )
    private List<Plat> plats;

    public void calculerTotal() {
        this.total = plats.stream()
                .mapToDouble(Plat::getPrix)
                .sum();
    }

    // Modifier ici pour correspondre à l'attribut "tab" de Tab
    @ManyToOne
    @JoinColumn(name = "idTable", nullable = false)
    private Tab tab;  // Renommer "table" en "tab"
}
