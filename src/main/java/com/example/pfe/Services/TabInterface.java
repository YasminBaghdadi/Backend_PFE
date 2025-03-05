package com.example.pfe.Services;

import com.example.pfe.Entity.Tab;
import com.example.pfe.Entity.User;

import java.util.List;

public interface TabInterface {

    Tab getTab(Long idTable);

    List<Tab> getAllTabs(int page, int size);

    String addTab(Tab tab);

   void delete(Long idTable);

    public Tab update(Long idTable, Tab tab);
}
