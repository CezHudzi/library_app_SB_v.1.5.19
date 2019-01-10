package com.application.library.services;


import com.application.library.mapperDTO.bookmapper.BookCreateDTO;
import com.application.library.mapperDTO.bookmapper.BookMapper;
import com.application.library.mapperDTO.bookmapper.BookResponse;
import com.application.library.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepositiry bookRepositiry;
    private final BookMapper bookMapper;

    @Autowired
    public BookService(BookRepositiry bookRepositiry, BookMapper bookMapper)
    {
        this.bookRepositiry = bookRepositiry;
        this.bookMapper=bookMapper;
    }




    public void addBook(BookCreateDTO bookDTO) {
        bookRepositiry.save(bookMapper.createNew(bookDTO));
    }


    public List<BookResponse> getAllBookServ() {

    return bookRepositiry.findAll().stream().map(bookMapper::cereateResponse).collect(Collectors.toList());

    }
}
