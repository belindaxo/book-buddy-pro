package com.example.bookbuddypro.repository;

import com.example.bookbuddypro.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
