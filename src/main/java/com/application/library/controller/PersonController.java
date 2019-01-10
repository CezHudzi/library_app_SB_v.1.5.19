package com.application.library.controller;


import com.application.library.mapperDTO.personmapper.PersonCreateDTO;
import com.application.library.mapperDTO.personmapper.PersonResponse;
import com.application.library.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;


    public PersonController(PersonService personService) {
        this.personService = personService;
    }



    @GetMapping
    public List<PersonResponse> getAllPerson()
    {
        return personService.getAllPersonServ();
    }






    @PostMapping
    public void addPerson(@RequestBody PersonCreateDTO person) {
        personService.addPerson(person);
    }





}
