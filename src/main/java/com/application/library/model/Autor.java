package com.application.library.model;
import javax.persistence.*;
import java.util.Set;



@Entity
public
class Autor {
    public Autor() {
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //public Set<Book> getBook() {
   //     return book;
  //  }

    public void setBook(Set<Book> book) {
        this.book = book;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long autorId;

    private String firstName;
    private String lastName;


    @ManyToMany(mappedBy = "author")
    private Set<Book> book;



}
