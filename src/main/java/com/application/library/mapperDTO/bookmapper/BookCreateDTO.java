package com.application.library.mapperDTO.bookmapper;




import java.util.Set;

public class BookCreateDTO {



    private String bookName;
    private Set<Integer> author;

    public BookCreateDTO(String bookName, Set<Integer> author) {
        this.bookName = bookName;
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }


    public Set<Integer> getAuthorSet() {
        return author;
    }
}

