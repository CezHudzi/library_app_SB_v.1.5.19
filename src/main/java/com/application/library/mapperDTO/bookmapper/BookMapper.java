package com.application.library.mapperDTO.bookmapper;


import com.application.library.model.Autor;
import com.application.library.model.Book;
import com.application.library.services.AutorService;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BookMapper {


    AutorService autorService;


    public BookMapper(AutorService autorService) {
        this.autorService = autorService;
    }



    public BookResponse cereateResponse(Book book)
    {
        Set<Autor> autorSet= book.getAuthor();
        Set<String> autorString= new HashSet();
        for (Autor autor : autorSet)
        {
            autorString.add(autor.getFirstName()+"  "+autor.getLastName());

        }


        return new BookResponse(book.getIdBook(),book.getBookName(),autorString);
    }




    public Book createNew  (BookCreateDTO bookDTO)
    {

        Book book = new Book();
        Set<Integer> idSet = bookDTO.getAuthorSet();
        Set<Autor> autorSet = new HashSet<>();


        for(Integer i : idSet)
        {
            autorSet.add(autorService.getAutorById(i));

        }

        book.setBookName(bookDTO.getBookName());
        book.setAuthor(autorSet);

        return book;
    }



}
