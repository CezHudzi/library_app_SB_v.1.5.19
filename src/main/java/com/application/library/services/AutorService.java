package com.application.library.services;


import com.application.library.mapperDTO.autormapper.AutorCreateDTO;
import com.application.library.mapperDTO.autormapper.AutorMapper;
import com.application.library.mapperDTO.autormapper.AutorResponse;
import com.application.library.model.Autor;
import com.application.library.repo.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AutorService {

    private final AutorRepository autorRepository;
    private final AutorMapper autorMapper;

    public AutorService(AutorRepository autorRepository, AutorMapper autorMapper) {
        this.autorRepository = autorRepository;
        this.autorMapper = autorMapper;
    }



    public void addAutor(AutorCreateDTO autorDTO) {
    autorRepository.save(autorMapper.createNew(autorDTO));
    }


    public Autor getAutorById(Integer autorId)
    {

        Optional<Autor> autor = Optional.ofNullable(autorRepository.findOne(autorId.longValue()));

    if (autor.isPresent())
    {
        return autor.get();
    }
    else
    {

        return new Autor();
    }


    }


    public List<AutorResponse> getAllAutor() {

        return autorRepository.findAll().stream().map(autorMapper::autorResponse).collect(Collectors.toList());


    }



}
