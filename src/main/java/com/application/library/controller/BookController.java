package com.application.library.controller;



import com.application.library.mapperDTO.bookmapper.BookCreateDTO;
import com.application.library.mapperDTO.bookmapper.BookResponse;
import com.application.library.services.BookService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public List<BookResponse> getAllPerson()
    {
        return bookService.getAllBookServ();
    }


    @PostMapping
    public void addBook(@RequestBody BookCreateDTO bookDTO) {
        bookService.addBook(bookDTO);
    }



}
