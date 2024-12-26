package com.example.bookbuddypro.repository;

import com.example.bookbuddypro.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
