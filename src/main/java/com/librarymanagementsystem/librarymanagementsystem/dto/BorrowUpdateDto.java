package com.librarymanagementsystem.librarymanagementsystem.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowUpdateDto {

    private Integer borrowId;

    private LocalDate borrowDate;

    private LocalDate returnDate;

    private Integer book;

    private Integer user;
}
