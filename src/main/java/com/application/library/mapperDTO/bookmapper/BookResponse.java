package com.application.library.mapperDTO.bookmapper;



import com.application.library.model.Autor;

import java.util.Set;

public class BookResponse {




    private final long bookId;
    private final String bookName;
    private final Set<String> autorList;
    private final boolean avalable;

    public long getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public Set<String> getAutorList() {
        return autorList;
    }

    public boolean isAvalable() {
        return avalable;
    }

    BookResponse(long bookId, String bookName, Set<String> autorList, boolean avalable) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.autorList = autorList;
        this.avalable = avalable;
    }
}
