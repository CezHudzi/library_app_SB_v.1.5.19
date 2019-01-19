package com.application.library.mapperDTO.bookmapper;



import com.application.library.model.Autor;

import java.util.Set;

public class BookResponse {




    private final long bookId;
    private final String bookName;
    private final Set<String> autorList;


    public long getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public Set<String> getAutorList() {
        return autorList;
    }

    BookResponse(long bookId, String bookName, Set<String> autorList) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.autorList = autorList;
    }
}
