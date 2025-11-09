package com.librarymanagementsystem.librarymanagementsystem.repo;

import com.librarymanagementsystem.librarymanagementsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Integer> {
}
