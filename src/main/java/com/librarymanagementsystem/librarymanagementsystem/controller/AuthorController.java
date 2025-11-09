package com.librarymanagementsystem.librarymanagementsystem.controller;


import com.librarymanagementsystem.librarymanagementsystem.dto.AuthorDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.AuthorSaveDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.AuthorUpdateDto;
import com.librarymanagementsystem.librarymanagementsystem.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/author")
public class AuthorController {
    @Autowired
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<String> saveAuthor(@RequestBody AuthorSaveDto  authorSaveDto) {
        authorService.addAuthor(authorSaveDto);
        return ResponseEntity.ok("Author saved successfully");
    }


    @GetMapping(path = "/getAllAuthors")
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        List<AuthorDto> getAuthors= authorService.getALlAuthors();
        return ResponseEntity.ok(getAuthors);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<String> updateAuthor(@RequestBody AuthorUpdateDto authorUpdateDto) {
        authorService.updateAuthor(authorUpdateDto);
        return ResponseEntity.ok("Author updated successfully");
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable(value = "id") Integer id) {
        boolean authorDeleted=authorService.deleteAuthor(id);
        if(authorDeleted){
            return ResponseEntity.ok("Author deleted successfully");
        }
        return ResponseEntity.badRequest().build();
    }

}
