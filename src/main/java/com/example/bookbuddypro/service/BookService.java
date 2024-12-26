package com.example.bookbuddypro.service;

import com.example.bookbuddypro.model.Book;
import com.example.bookbuddypro.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Retrieve all books
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    // Retrieve a book by its id
    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Save a new or updated book
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // Delete a book by its id
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

}
