package com.application.library.services;


import com.application.library.mapperDTO.bookmapper.BookMapper;
import com.application.library.mapperDTO.bookmapper.BookResponse;
import com.application.library.mapperDTO.borrowmapper.BorrowCreateDTO;
import com.application.library.mapperDTO.borrowmapper.BorrowMapper;
import com.application.library.mapperDTO.borrowmapper.BorrowResponse;
import com.application.library.model.Book;
import com.application.library.model.Borrow;
import com.application.library.model.Person;
import com.application.library.repo.BookRepositiry;
import com.application.library.repo.BorrowRepository;
import com.application.library.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class BorrowService {

    private final BookRepositiry bookRepositiry;
    private final PersonRepository personRepository;
    private final BorrowRepository borrowRepository;
    private final BorrowMapper borrowMapper;

    private final PersonService personService;
    private final BookService bookService;

    @Autowired
    public BorrowService(BookRepositiry bookRepositiry, PersonRepository personRepository,
                         BorrowRepository borrowRepository, BorrowMapper borrowMapper,
                         PersonService personService,BookService bookService) {
        this.bookRepositiry = bookRepositiry;
        this.borrowRepository = borrowRepository;
        this.personRepository = personRepository;
        this.borrowMapper = borrowMapper;
        this.personService = personService;
        this.bookService = bookService;
    }





    public void addRent(BorrowCreateDTO borrowDTO){
        borrowRepository.save(borrowMapper.createNew(borrowDTO));
    }


    public void getRent(BorrowCreateDTO borrowDTO){
        borrowRepository.save(borrowMapper.createNew(borrowDTO));
    }



    public List<BorrowResponse> getAllBorrowServ() {
        return borrowRepository.findAll().stream().map(borrowMapper::cereateResponse).collect(Collectors.toList());
    }


    //TODO DELETE WITH ID FINDER



    public void delateRent(BorrowCreateDTO borrowDTO){
        Long index = borrowDTO.getBookId().longValue();
        borrowRepository.delete(index);
    }




}
