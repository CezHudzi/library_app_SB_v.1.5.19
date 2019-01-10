package com.application.library.services;


import com.application.library.model.Book;
import com.application.library.model.Borrow;
import com.application.library.model.Person;
import com.application.library.repo.BookRepositiry;
import com.application.library.repo.BorrowRepository;
import com.application.library.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class BorrowService {

    private final BookRepositiry bookRepositiry;
    private final PersonRepository personRepository;
    private final BorrowRepository borrowRepository;


    @Autowired
    public BorrowService(BookRepositiry bookRepositiry, PersonRepository personRepository, BorrowRepository borrowRepository) {
        this.bookRepositiry = bookRepositiry;
        this.borrowRepository = borrowRepository;
        this.personRepository = personRepository;
    }




    public void rentBook(Long bookId,Long personId)
    {

        LocalDateTime createdAt = LocalDateTime.now();

        Optional<Book> book = Optional.ofNullable(bookRepositiry.findOne(bookId));
        Optional<Person> person = Optional.ofNullable(personRepository.findOne(personId));


        if(book.isPresent())
        {
            if(person.isPresent())
            {
                Borrow temp = new Borrow(createdAt,book.get(),person.get());
                borrowRepository.save(temp);
            }
            else
            {System.out.println("Nie udano dodac");}


        }
        else
        {System.out.println("Nie udano dodac");}




    }


}
