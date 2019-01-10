package com.application.library.repo;


import com.application.library.model.Borrow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends CrudRepository<Borrow, Long> {






}
