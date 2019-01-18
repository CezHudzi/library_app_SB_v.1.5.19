package com.application.library.controller;

import com.application.library.mapperDTO.borrowmapper.BorrowCreateDTO;
import com.application.library.mapperDTO.borrowmapper.BorrowResponse;
import com.application.library.services.BorrowService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrows")
public class BorrowController {

    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }


    @GetMapping
    public List<BorrowResponse> getAllPerson()
    {
        return borrowService.getAllBorrowServ();
    }


    @PostMapping
    public void addBorrow(@RequestBody BorrowCreateDTO borrowDTO) {
        borrowService.addRent(borrowDTO);
    }


   // @DeleteMapping
   // public void deleteBorrow(@RequestBody BorrowCreateDTO borrowDTO){
  //      borrowService.delateRent(borrowDTO);
  //  }

     @DeleteMapping
     public void deleteBorrow(@RequestBody BorrowCreateDTO borrowDTO){
          borrowService.delateRentWherIdBookIdUser(borrowDTO);
      }





}
