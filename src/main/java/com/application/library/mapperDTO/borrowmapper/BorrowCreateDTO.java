package com.application.library.mapperDTO.borrowmapper;

public class BorrowCreateDTO {

    public BorrowCreateDTO(Integer bookId, Integer personId) {
        this.bookId = bookId;
        this.personId = personId;
    }

    private Integer bookId;
    private Integer personId;

    public Integer getBookId() {
        return bookId;
    }

    public Integer getPersonId() {
        return personId;
    }
}
