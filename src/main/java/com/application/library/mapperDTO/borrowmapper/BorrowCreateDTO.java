package com.application.library.mapperDTO.borrowmapper;

import com.application.library.services.PersonService;

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


    public Integer getBookObjectById() {
        return bookId;
    }

    public Integer getPersonObjectById() {
        return personId;
    }


}
