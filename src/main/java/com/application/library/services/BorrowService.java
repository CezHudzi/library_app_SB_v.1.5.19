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


//TODO RENT AND DELATE


}
