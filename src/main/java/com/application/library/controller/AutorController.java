package com.application.library.controller;



import com.application.library.mapperDTO.autormapper.AutorCreateDTO;
import com.application.library.mapperDTO.autormapper.AutorResponse;
import com.application.library.services.AutorService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/autors")
public class AutorController {


    private final AutorService autorService;


    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }


    @GetMapping
    public List<AutorResponse> getAllPerson()
    {
        return autorService.getAllAutor();
    }





    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public void addPerson(@RequestBody AutorCreateDTO autorDTO) {
        autorService.addAutor(autorDTO);
    }





}
