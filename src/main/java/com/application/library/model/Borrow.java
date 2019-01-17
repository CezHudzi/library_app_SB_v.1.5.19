package com.application.library.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrows")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBorrow;
    private LocalDateTime borrowedAt;
    private LocalDateTime returnAt;
    private Integer fine;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Person person;


    public Long getIdBorrow() {
        return idBorrow;
    }

    public LocalDateTime getBorrowedAt() {
        return borrowedAt;
    }

    public LocalDateTime getReturnAt() {
        return returnAt;
    }

    public Integer getFine() {
        return fine;
    }

    public Book getBook() {
        return book;
    }

    public Person getPerson() {
        return person;
    }

    public Borrow(Person person, Book book) {
        this.borrowedAt = LocalDateTime.now();
        this.returnAt = LocalDateTime.now().plusMonths(1);

        this.book = book;
        this.person = person;

    }
    public Borrow() {


    }


}
