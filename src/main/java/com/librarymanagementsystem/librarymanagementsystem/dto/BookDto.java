package com.librarymanagementsystem.librarymanagementsystem.dto;

import com.librarymanagementsystem.librarymanagementsystem.entity.Author;
import com.librarymanagementsystem.librarymanagementsystem.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Integer bookId;
    private String title;
    private Author author;
    private Publisher publisher;
}
