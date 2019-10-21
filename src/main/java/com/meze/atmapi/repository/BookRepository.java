package com.meze.atmapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.meze.atmapi.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
