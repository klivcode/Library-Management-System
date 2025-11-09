package com.librarymanagementsystem.librarymanagementsystem.controller;


import com.librarymanagementsystem.librarymanagementsystem.dto.BookDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.BookSaveDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.BookUpdateDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.response.ResponseDto;
import com.librarymanagementsystem.librarymanagementsystem.entity.Book;
import com.librarymanagementsystem.librarymanagementsystem.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping(path = "/save")
     public ResponseEntity<String> saveBook(@RequestBody BookSaveDto bookSaveDto) {
        bookService.addBook(bookSaveDto);
        return ResponseEntity.ok("Added Book Successfully");
    }

    @GetMapping(path = "/getAllBooks")
    public ResponseEntity<ResponseDto> getAllBooks() {
        List<BookDto> listOfBooks = bookService.getAllBook();

        if(listOfBooks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDto("No Books Found","Failed",null));
        }
        return ResponseEntity.ok(
                new ResponseDto("Books retrieved successfully", "SUCCESS", listOfBooks)
        );
    }

    @PutMapping(path = "/update")
    public ResponseEntity<ResponseDto> updateBook(@RequestBody BookUpdateDto bookUpdateDto) {
        BookDto updatedDto= bookService.updateBook(bookUpdateDto);

        if(updatedDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDto("Book Not Found","Failed",null));
        }

        return ResponseEntity.ok(
                new ResponseDto("Book updated successfully", "SUCCESS", updatedDto));
    }


    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ResponseDto> deleteBook(@PathVariable(value = "id") Integer id) {
        boolean deletedBook= bookService.deleteBook(id);
        if(deletedBook) {
            return ResponseEntity.ok(new ResponseDto("Book Deleted Successfully", "SUCCESS", null));
        }
        return ResponseEntity.ok(new ResponseDto("Book Not Found", "Failed", null));
    }

}
