package com.librarymanagementsystem.librarymanagementsystem.services;

import com.librarymanagementsystem.librarymanagementsystem.dto.AuthorDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.AuthorSaveDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.AuthorUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    void addAuthor(AuthorSaveDto authorSaveDto);


    List<AuthorDto> getALlAuthors();

    void updateAuthor(AuthorUpdateDto authorUpdateDto);

    boolean deleteAuthor(Integer id);
}
