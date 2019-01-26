package com.application.library.controller;


import com.application.library.mapperDTO.personmapper.PersonResponse;
import com.application.library.mapperDTO.seciuritimapper.SeciuritiDTO;
import com.application.library.mapperDTO.seciuritimapper.SeciuritiResponse;
import com.application.library.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/valid")

public class ValidationControler {

    public final UserService userService;


    public ValidationControler(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public SeciuritiResponse checkValid(@RequestBody SeciuritiDTO seciuritiDTO) throws Exception {
        return userService.checkValidation(seciuritiDTO);
    }






}
