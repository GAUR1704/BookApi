package com.prowings.bookApi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.prowings.bookApi.Entity.Book;
import com.prowings.bookApi.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository repository;

	@Override
	public Book addBook(Book book) {
		return repository.save(book);
	}

	@Override
	public Optional<Book> getBookById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Book> listAllBooks(String sortBy) {
		return repository.findAll(Sort.by(sortBy));
	}

	@Override
	public Book updateBook(Long id, Book bookDetails) {
		Book book = repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setCategory(bookDetails.getCategory());
        book.setProperties(bookDetails.getProperties());
        return repository.save(book);
	}

	@Override
	public void deleteBook(Long id) {
		repository.deleteById(id);
		
	}

}
