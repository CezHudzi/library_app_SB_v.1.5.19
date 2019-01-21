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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBorrow;

   @Column(name = "updated_at")
    private LocalDate updated_at;
    @Column(name = "return_at")
    private LocalDate returnAt;
    private BigDecimal fine;
    private BigDecimal fineEuro;

    public BigDecimal getFineEuro() {
        return fineEuro;
    }

    public void setFineEuro(BigDecimal fineEuro) {
        this.fineEuro = fineEuro;
    }

    @ManyToOne
    private Book book;

    @ManyToOne
    private Person person;





    public Long getIdBorrow() {
        return idBorrow;
    }

    public LocalDate getBorrowedAt() {
        return updated_at;
    }

    public LocalDate getReturnAt() {
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

        this.updated_at = LocalDate.now();
        this.returnAt = updated_at.plusDays(7);
        this.fine= BigDecimal.valueOf(0);
        this.fineEuro= BigDecimal.valueOf(0);
        this.book = book;
        this.person = person;

    }




    public Borrow() {


    }

    public void setIdBorrow(Long idBorrow) {
        this.idBorrow = idBorrow;
    }

    public void setBorrowedAt(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public void setReturnAt(LocalDate returnAt) {
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


    public String getBorrowedAtString() {
        return this.updated_at.toString();
    }

    public String getReturnAtString() {
        return this.returnAt.toString();
    }
}
