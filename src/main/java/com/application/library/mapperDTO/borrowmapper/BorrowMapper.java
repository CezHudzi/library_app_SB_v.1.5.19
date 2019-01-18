package com.application.library.mapperDTO.borrowmapper;

import com.application.library.model.Book;
import com.application.library.model.Borrow;
import com.application.library.model.Person;
import com.application.library.services.BookService;
import com.application.library.services.PersonService;
import org.springframework.stereotype.Component;

@Component
public class BorrowMapper {


    private BookService bookService;
    private PersonService personService;




    public BorrowMapper(BookService bookService, PersonService personService) {
        this.bookService = bookService;
        this.personService = personService;
    }

    public Borrow createNew (BorrowCreateDTO borrowDTO){

        Person person = personService.getPersonById(borrowDTO.getPersonId());
        Book book = bookService.getBookById(borrowDTO.getBookId());

        return new Borrow(person, book);
    }


    public BorrowResponse cereateResponse(Borrow borrow)
    {
        return new BorrowResponse(borrow.getBorrowedAtString(), borrow.getReturnAtString(), borrow.getFine(),borrow.getFineEuro(), borrow.getPersonName(), borrow.getPersonSurename(), borrow.getBookName() );
    }




}
