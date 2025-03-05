package com.example.pfe.ServicesImpl;

import com.example.pfe.Entity.Tab;
import com.example.pfe.Entity.User;
import com.example.pfe.Repository.TabRepository;
import com.example.pfe.Services.TabInterface;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabService implements TabInterface {

    @Autowired
    private TabRepository tabRepository;

    @Override
    public String addTab(Tab tab) {
        String ch = "";
        if (tabRepository.existsByNumber(tab.getNumber())) {
            ch = " tab already exists";
        } else {
            tabRepository.save(tab);
            ch = "tab added !!";
        }
        return ch;
    }

    @Override
    public void delete(Long idTable)
    {
        tabRepository.deleteById(idTable);
    }



    @Override
    public Tab update(Long idTable, Tab tab) {
        Tab table = tabRepository.findById(idTable).get();
        table.setNumber(tab.getNumber());
        return tabRepository.save(table);
    }

    @Override
    public List<Tab> getAllTabs(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Tab> tabsPage = tabRepository.findAll(pageable);
        return tabsPage.getContent();
    }


    public Tab getTab(Long idTable) {
        return tabRepository.findById(idTable).orElse(null);  // Retourne null si l'objet n'existe pas
    }

}
