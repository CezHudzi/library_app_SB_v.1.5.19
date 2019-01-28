package com.application.library.security;

import com.application.library.model.User;
import com.application.library.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnUserDetailsService implements UserDetailsService {

    private final UserRepository usersRepository;

    @Autowired
    public OwnUserDetailsService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public String getPass(OwnUserDetails user){
        return user.getPassword();
    }



    @Override
    public OwnUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUsers = usersRepository.findByName(username);

        optionalUsers
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUsers
                .map(OwnUserDetails::new).get();
    }
}
