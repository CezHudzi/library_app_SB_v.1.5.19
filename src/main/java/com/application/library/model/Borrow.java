package com.application.library.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalDate;


@Entity
@Table(name = "borrows")
public class Borrow {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBorrow;
   // @Temporal(TemporalType.TIMESTAMP)
    private Integer borrowedAt;
    private Integer returnAt;
    private BigDecimal fine;
    private BigDecimal fineEuro;

    public BigDecimal getFineEuro() {
        return fineEuro;
    }

    public void setFineEuro(BigDecimal fineEuro) {
        this.fineEuro = fineEuro;
    }

    @OneToOne
    private Book book;

    @ManyToOne
    private Person person;





    public Long getIdBorrow() {
        return idBorrow;
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

    public Book getBook() {
        return book;
    }

    public Person getPerson() {
        return person;
    }

    public Borrow(Person person, Book book) {

        this.borrowedAt = 30;
        this.returnAt = 3;
        this.fine= BigDecimal.valueOf(0);
        this.book = book;
        this.person = person;

    }

    public Borrow(Integer index, Person person, Book book) {
    this.idBorrow = index.longValue();
        this.borrowedAt = 30;
        this.returnAt = 3;

        this.book = book;
        this.person = person;

    }


    public Borrow() {


    }

    public void setIdBorrow(Long idBorrow) {
        this.idBorrow = idBorrow;
    }

    public void setBorrowedAt(Integer borrowedAt) {
        this.borrowedAt = borrowedAt;
    }

    public void setReturnAt(Integer returnAt) {
        this.returnAt = returnAt;
    }

    public void setFine(BigDecimal fine) {
        this.fine = fine;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPersonSurename(){
        return person.getLastName();
    }

    public String getPersonName(){
        return person.getFirstName();
    }

    public String getBookName(){
        return book.getBookName();
    }





}
