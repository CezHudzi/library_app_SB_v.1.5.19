package com.application.library.mapperDTO.autormapper;


import java.util.Set;

public class AutorResponse {


    private Long autorId;
    private String firstName;
    private String lastName;
   // private Set<Book> book;

    public AutorResponse(Long autorId, String firstName, String lastName) {
        this.autorId = autorId;
        this.firstName = firstName;
        this.lastName = lastName;
    //    this.book = book;
    }

    public Long getAutorId() {
        return autorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

   // public Set<Book> getBook() {
 //       return book;
 //   }
}
