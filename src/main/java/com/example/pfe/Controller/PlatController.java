package com.example.pfe.Controller;

import com.example.pfe.Entity.Plat;
import com.example.pfe.Entity.User;
import com.example.pfe.Services.PlatInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Plat")
public class PlatController {
    @Autowired
    PlatInterface platInterface;

    @PostMapping("/addplat")
    public Plat addPlat(@RequestBody Plat plat) {
        return platInterface.addPlat(plat);
    }

    @DeleteMapping("/deleteplat/{idPlat}")
    public void deletePlat(@PathVariable Long idPlat) {
       platInterface.deletePlat(idPlat);
    }
    @PutMapping("/update/{idPlat}")
    public Plat updatePlat(@PathVariable Long idPlat, @RequestBody Plat plat) {
        return platInterface.updatePlat(idPlat, plat);
    }

    @GetMapping("/getplat/{name}")
    public Plat getPlatByName(@PathVariable("name") String name) {
        return platInterface.getPlatByName(name);
    }
    @GetMapping("/getplats")
    public List<Plat> getplats()
    {
        return platInterface.getplats();
    }
}
