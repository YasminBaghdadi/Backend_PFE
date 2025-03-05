package com.example.pfe.ServicesImpl;

import com.example.pfe.Entity.Role;
import com.example.pfe.Repository.RoleRepository;
import com.example.pfe.Repository.UserRepository;
import com.example.pfe.Services.RoleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServices implements RoleInterface {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }
}
