package com.application.library.mapperDTO.borrowmapper;

import com.application.library.model.Book;
import com.application.library.model.Person;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BorrowResponse {

    private Long idBorrow;
    @Column(name = "created_at")
    private String created_at;
    private String returnAt;
    private BigDecimal fine;
    private BigDecimal fineEuro;
    private String bookname;
    private String name;
    private String surname;



    public BorrowResponse(  String created_at, String returnAt, BigDecimal fine,BigDecimal fineEuro, String name, String surname, String bookname, Long idBorrow) {


        this.idBorrow = idBorrow;
        this.created_at = created_at;
        this.returnAt = returnAt;
        this.fine = fine;
        this.fineEuro = fineEuro;
        this.bookname = bookname;
        this.name = name;
        this.surname=surname;
    }

    public Long getIdBorrow() {
        return idBorrow;
    }



    public BigDecimal getFineEuro() {
        return fineEuro;
    }

    public String getBorrowedAt() {
        return created_at;
    }

    public String getReturnAt() {
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
