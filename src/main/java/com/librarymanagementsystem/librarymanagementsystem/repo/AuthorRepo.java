package com.librarymanagementsystem.librarymanagementsystem.repo;

import com.librarymanagementsystem.librarymanagementsystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Integer> {
}
