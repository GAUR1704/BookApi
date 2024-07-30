package com.prowings.bookApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prowings.bookApi.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	

}
