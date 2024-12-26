package com.example.bookbuddypro.repository;

import com.example.bookbuddypro.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
