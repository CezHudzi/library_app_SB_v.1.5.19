package com.application.library.mapperDTO.borrowmapper;

import com.application.library.model.Book;
import com.application.library.model.Person;

import java.time.LocalDateTime;

public class BorrowResponse {

    private LocalDateTime borrowedAt;
    private LocalDateTime returnAt;
    private Integer fine;
    private Book book;
    private Person person;


    public BorrowResponse(LocalDateTime borrowedAt, LocalDateTime returnAt, Integer fine,  Person person, Book book) {
        this.borrowedAt = borrowedAt;
        this.returnAt = returnAt;
        this.fine = fine;
        this.book = book;
        this.person = person;
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
}
