package com.librarymanagementsystem.librarymanagementsystem.services;

import com.librarymanagementsystem.librarymanagementsystem.dto.BookDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.BookSaveDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.BookUpdateDto;
import com.librarymanagementsystem.librarymanagementsystem.entity.Book;

import java.util.List;

public interface BookService {
    void addBook(BookSaveDto bookSaveDto);


    List<BookDto> getAllBook();

    BookDto updateBook(BookUpdateDto bookUpdateDto);

    boolean deleteBook(Integer id);
}
