package com.application.library.services;


import com.application.library.mapperDTO.borrowmapper.BorrowCreateDTO;
import com.application.library.mapperDTO.borrowmapper.BorrowMapper;
import com.application.library.mapperDTO.borrowmapper.BorrowResponse;
import com.application.library.model.Book;
import com.application.library.model.Borrow;

import com.application.library.repo.BookRepositiry;
import com.application.library.repo.BorrowRepository;
import com.application.library.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
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


    @PersistenceContext
    private EntityManager manager;


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




    public List<BorrowResponse> getAllBorrowServ() {

        return borrowRepository.findAll().stream().map(borrowMapper::cereateResponse)
              .collect(Collectors.toList());
    }





    public void extednRentSevenDays(Integer borrowId) {

        Long index = borrowId.longValue();
        Borrow borrow = borrowRepository.findOne(index);
        borrow.setReturnAt(borrow.getReturnAt().plusDays(7));
        borrowRepository.save(borrow);
    }



    public void delateRent(Integer borrowId){
        Long index = borrowId.longValue();
         Borrow borrow = borrowRepository.getOne(index);

        Book book = borrow.getBook();

        book.setAvalable(true);

        borrowRepository.delete(index);
    }



    @Transactional
    @Rollback(true)
    public void delateRentWherIdBookIdUser(BorrowCreateDTO borrowCreateDTO){

        Query query = manager.createNativeQuery("DELETE FROM borrows WHERE borrows.book_id_book ="+borrowCreateDTO.getBookId() + "  AND borrows.person_id_user ="+borrowCreateDTO.getPersonId());
        query.executeUpdate();

    }



    public void updateBorrow(Borrow borrow){



        borrowRepository.save(borrow);
    }



    public List<Borrow> gerBorrowPeriod(){

        return borrowRepository.findAll();
    }


    public Borrow getBorrowById(Integer borrowId)
    {

        Optional<Borrow> borrow = Optional.ofNullable(borrowRepository.findOne(borrowId.longValue()));

        if (borrow.isPresent())
        {
            return borrow.get();
        }
        else
        {

            return new Borrow();
        }


    }




}
