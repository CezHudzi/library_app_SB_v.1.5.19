package com.application.library.mapperDTO.bookmapper;




import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bookName",
        "author"
})
public class BookCreateDTO {


    @JsonProperty("bookName")
    private String bookName;
    @JsonProperty("author")
    private Set<Integer> author;

    public BookCreateDTO() {
    }

    public BookCreateDTO(String bookName, Set<Integer> author) {
        this.bookName = bookName;
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }


    public Set<Integer> getAuthorSet()
    {
        return author;
    }
}

