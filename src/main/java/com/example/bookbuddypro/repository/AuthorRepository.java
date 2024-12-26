package com.example.bookbuddypro.repository;

import com.example.bookbuddypro.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
