package com.prowings.bookApi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.bookApi.Entity.Book;
import com.prowings.bookApi.Service.BookService;

@RestController
public class BookController {
	
	@Autowired
	public BookService service;
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		
		return service.addBook(book);
		
	}
	
	@GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return service.getBookById(id);
    }
	
	@PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return service.updateBook(id, bookDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
    }
	
	@GetMapping
    public List<Book> listAllBooks(@RequestParam String sortBy) {
        return service.listAllBooks(sortBy);
    }

}
