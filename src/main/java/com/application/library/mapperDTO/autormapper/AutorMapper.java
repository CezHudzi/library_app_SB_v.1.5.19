package com.application.library.mapperDTO.autormapper;


import com.application.library.model.Autor;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper {


    public AutorMapper() {
    }

    public Autor createNew (AutorCreateDTO AutorDTO)
    {
        Autor autor = new Autor();
        autor.setLastName(AutorDTO.getLastName());
        autor.setFirstName(AutorDTO.getFirstName());
        return autor;
    }


    public AutorResponse autorResponse(Autor autor)
    {
        return new AutorResponse(autor.getAutorId(),autor.getFirstName(), autor.getLastName());
    }




}
