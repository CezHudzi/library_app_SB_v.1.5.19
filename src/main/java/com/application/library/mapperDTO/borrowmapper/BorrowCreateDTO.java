package com.application.library.mapperDTO.borrowmapper;

import com.application.library.services.PersonService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bookId",
        "personId"
})
public class BorrowCreateDTO {


    private Integer bookId;
    private Integer personId;



    public BorrowCreateDTO(Integer bookId, Integer personId) {
        this.bookId = bookId;
        this.personId = personId;
    }


    public BorrowCreateDTO() {
    }

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
