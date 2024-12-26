package com.example.bookbuddypro.controller;

import com.example.bookbuddypro.model.Book;
import com.example.bookbuddypro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // GET /books - returns all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    // Get /books/{id} - returns a book by its id
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.findBookById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /books - creates a new book
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    // PUT /books/{id} - updates an existing book by its id
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Optional<Book> book = bookService.findBookById(id);
        if (book.isPresent()) {
            Book updatedBook = book.get();
            updatedBook.setTitle(bookDetails.getTitle());
            updatedBook.setAuthors(bookDetails.getAuthors());
            updatedBook.setCoverImagePath(bookDetails.getCoverImagePath());
            updatedBook.setRating(bookDetails.getRating());
            updatedBook.setDescription(bookDetails.getDescription());
            updatedBook.setDatePublished(bookDetails.getDatePublished());
            updatedBook.setFolders(bookDetails.getFolders());
            updatedBook.setFormat(bookDetails.getFormat());
            updatedBook.setTags(bookDetails.getTags());
            return ResponseEntity.ok(bookService.saveBook(updatedBook));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /books/{id} - deletes a book by its id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (bookService.findBookById(id).isPresent()) {
            bookService.deleteBookById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
