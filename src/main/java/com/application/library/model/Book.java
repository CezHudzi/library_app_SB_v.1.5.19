package com.application.library.model;


import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "books")
public class Book {

    public Book(String bookName, Set<Autor> author) {
        this.bookName = bookName;
        this.author = author;
        this.avalable= true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;

    private String bookName;


    public Book(String bookName, String bookAutor) {
        this.bookName = bookName;

    }

    public Book() {
        this.avalable = true;
    }

    @OneToMany (mappedBy = "book")
    private Set<Borrow> borrow;



    @ManyToMany
    @JoinTable(
            name = "authors_book",
            joinColumns = {@JoinColumn(name = "idBook")},
            inverseJoinColumns = {@JoinColumn(name = "autorId")}
    )
    private Set<Autor> author;


    private boolean avalable;

    public boolean isAvalable() {
        return avalable;
    }

    public void setAvalable(boolean avalable) {
        this.avalable = avalable;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }


    public String getBookName() {
        return bookName;
    }


    public Set<Borrow> getBorrow() {
        return borrow;
    }

    public Set<Autor> getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                '}';
    }


    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBorrow(Set<Borrow> borrow) {
        this.borrow = borrow;
    }

    public void setAuthor(Set<Autor> author) {
        this.author = author;
    }
}
