package com.application.library.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrows")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBorrow;
    private LocalDateTime createdAt;

    //private Long bookId;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Person person;


    public Borrow(LocalDateTime createdAt, Book book, Person person) {
        this.createdAt = createdAt;
        this.book = book;
        this.person = person;

    }
    public Borrow() {


    }


}
