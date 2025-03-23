package com.example.pfe.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Data
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(nullable = false)
    private String username;

    private String firstname;
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;  /// -- mazelt verification email ///

    @Column(nullable = false)
    private String password;

    private String confirmPassword;

    @ManyToOne
    @JoinColumn(name = "idRole", nullable = false)
    @JsonIgnore
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Commande> commandes = new HashSet<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = true)
    private Image image;


}
