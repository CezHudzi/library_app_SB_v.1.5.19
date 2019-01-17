package com.application.library.services;


import com.application.library.mapperDTO.personmapper.PersonCreateDTO;
import com.application.library.mapperDTO.personmapper.PersonMapper;
import com.application.library.mapperDTO.personmapper.PersonResponse;
import com.application.library.model.Autor;
import com.application.library.model.Person;
import com.application.library.repo.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {


    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

//TODO WPISAC TO MAPOWANIE
    public Optional<Person> findF(Long i)
    {





      return Optional.ofNullable(personRepository.findOne(i));
    }


    public void addPerson(PersonCreateDTO personDTO) {
        personRepository.save(personMapper.createNew(personDTO));
    }

    public List<PersonResponse> getAllPersonServ() {

        return personRepository.findAll().stream().map(personMapper::cereateResponse).collect(Collectors.toList());

    }



    public Person getPersonById(Integer personId)
    {

        Optional<Person> person = Optional.ofNullable(personRepository.findOne(personId.longValue()));

        if (person.isPresent())
        {
            return person.get();
        }
        else
        {

            return new Person();
        }


    }




}
