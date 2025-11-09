package com.librarymanagementsystem.librarymanagementsystem.dto;

import com.librarymanagementsystem.librarymanagementsystem.entity.Book;
import com.librarymanagementsystem.librarymanagementsystem.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowDto {

    private Integer borrowId;

    private LocalDate borrowDate;

    private LocalDate returnDate;

    private Book book;

    private User user;
}
