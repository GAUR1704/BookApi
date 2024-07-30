package com.prowings.bookApi.Service;

import java.util.List;
import java.util.Optional;

import com.prowings.bookApi.Entity.Book;

public interface BookService {

	public Book addBook(Book book);

	public Optional<Book> getBookById(Long id);

	public List<Book> listAllBooks(String sortBy);

	public Book updateBook(Long id, Book bookDetails);

	public void deleteBook(Long id);

}
