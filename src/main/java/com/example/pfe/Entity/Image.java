package com.example.pfe.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@Entity
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage;
    private String Name;
    private String type;

    @Lob
    @Column(name = "picByte", columnDefinition  = "LONGBLOB")
    byte[] picByte;


    @OneToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", unique = true, nullable = true)
    private User user;


    @OneToOne
    @JoinColumn(name="idPlat", referencedColumnName = "idPlat", unique = true)
    private Plat plat;
}
