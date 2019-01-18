package com.application.library.mapperDTO.borrowmapper;

import com.application.library.model.Book;
import com.application.library.model.Person;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BorrowResponse {

    private Integer borrowedAt;
    private Integer returnAt;
    private BigDecimal fine;
    private BigDecimal fineEuro;
    private String bookname;
    private String name;
    private String surname;

    public BorrowResponse(Integer borrowedAt, Integer returnAt, BigDecimal fine,BigDecimal fineEuro, String name, String surname, String bookname) {
        this.borrowedAt = borrowedAt;
        this.returnAt = returnAt;
        this.fine = fine;
        this.fineEuro = fineEuro;
        this.bookname = bookname;
        this.name = name;
        this.surname=surname;
    }

    public BigDecimal getFineEuro() {
        return fineEuro;
    }

    public Integer getBorrowedAt() {
        return borrowedAt;
    }

    public Integer getReturnAt() {
        return returnAt;
    }

    public BigDecimal getFine() {
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
