package com.example.pfe.Services;

import com.example.pfe.Entity.Plat;

import java.util.List;

public interface PlatInterface {
    public Plat addPlat(Plat plat);
    void deletePlat(Long idPlat);
    public Plat updatePlat(Long idPlat,Plat plat);
    public Plat getPlatByName(String name);
    public List<Plat> getplats();
}
