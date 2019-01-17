package com.application.library.services;


import com.application.library.mapperDTO.bookmapper.BookCreateDTO;
import com.application.library.model.Role;
import com.application.library.model.User;
import com.application.library.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void addUser(String name, String password, Role role) {

        Set<Role> roleSet = new HashSet<Role>();
        roleSet.add(role);
        
        userRepository.save(new User(name, password,roleSet));
    }
    
    
    
    
}
