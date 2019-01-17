package com.application.library.services;


import com.application.library.mapperDTO.autormapper.AutorCreateDTO;
import com.application.library.model.Role;
import com.application.library.repo.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;


    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    public void addRole(Role role) {
        roleRepository.save(role);
    }

    public Role createRole(String roleName){
        return new Role(roleName);
    }



}
