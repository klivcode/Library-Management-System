package com.librarymanagementsystem.librarymanagementsystem.repo;

import com.librarymanagementsystem.librarymanagementsystem.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepo extends JpaRepository<Borrow,Integer> {
}
