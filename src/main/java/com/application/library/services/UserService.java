package com.application.library.services;


import com.application.library.mapperDTO.bookmapper.BookCreateDTO;
import com.application.library.mapperDTO.seciuritimapper.SeciuritiDTO;
import com.application.library.mapperDTO.seciuritimapper.SeciuritiMapper;
import com.application.library.mapperDTO.seciuritimapper.SeciuritiResponse;
import com.application.library.model.Role;
import com.application.library.model.User;
import com.application.library.repo.UserRepository;
import com.application.library.security.OwnUserDetails;
import com.application.library.security.OwnUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final OwnUserDetailsService ownUserDetailsService;
    private final SeciuritiMapper seciuritiMapper;

    public UserService(UserRepository userRepository, OwnUserDetailsService ownUserDetailsService, SeciuritiMapper seciuritiMapper) {
        this.userRepository = userRepository;
        this.ownUserDetailsService = ownUserDetailsService;
        this.seciuritiMapper=seciuritiMapper;
    }


    public void addUser(String name, String password, Role role) {

        Set<Role> roleSet = new HashSet<Role>();
        roleSet.add(role);
        
        userRepository.save(new User(name, password,roleSet));
    }


    public SeciuritiResponse checkValidation(SeciuritiDTO seciuritiDTO) throws Exception{

        Boolean valid = false;
        List<String> roles = null;

        try {
            OwnUserDetails userDetails = ownUserDetailsService.loadUserByUsername(seciuritiDTO.getLogin());
            if(userDetails.getPassword().equals(seciuritiDTO.getPassword())){
                valid=true;

                Set<Role> setRoles = userDetails.getRoles();
                 roles = setRoles.stream()
                        .map(Role::getRole)
                        .collect(Collectors.toList());


            }


        }
        catch (Exception e)
        {
           valid = false;
        }





        return seciuritiMapper.createResponse(valid,roles);






    };


    
    
    
}
