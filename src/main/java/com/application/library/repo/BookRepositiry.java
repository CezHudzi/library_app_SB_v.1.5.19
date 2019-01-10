package com.application.library.repo;



import com.application.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositiry extends JpaRepository<Book, Long> {
}
