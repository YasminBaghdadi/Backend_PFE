package com.example.pfe.Services;

import com.example.pfe.Entity.Commande;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface CommandeInterface {
    Map<String, Object> passerCommande(Long userId,Long idTable , List<Long> platIds);
    Map<String, Object> modifierCommande(Long idCmnd, Long idTable , List<Long> platIds);

    void supprimerCommande(Long idCmnd);


    List<Map<String, Object>> getAllCommandes();

    Map<String, Object> getCommandeById(Long idCmnd);

}
