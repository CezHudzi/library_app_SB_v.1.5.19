package com.application.library.mapperDTO.borrowmapper;

import com.application.library.model.Book;
import com.application.library.model.Person;

import java.time.LocalDateTime;

public class BorrowResponse {

    private LocalDateTime borrowedAt;
    private LocalDateTime returnAt;
    private Integer fine;
    private String bookname;
    private String name;
    private String surname;

    public BorrowResponse(LocalDateTime borrowedAt, LocalDateTime returnAt, Integer fine,  String name, String surname, String bookname) {
        this.borrowedAt = borrowedAt;
        this.returnAt = returnAt;
        this.fine = fine;
        this.bookname = bookname;
        this.name = name;
        this.surname=surname;
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

    public String getBookname() {
        return bookname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
