package com.librarymanagementsystem.librarymanagementsystem.services.impl;

import com.librarymanagementsystem.librarymanagementsystem.dto.AuthorDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.AuthorSaveDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.AuthorUpdateDto;
import com.librarymanagementsystem.librarymanagementsystem.entity.Author;
import com.librarymanagementsystem.librarymanagementsystem.repo.AuthorRepo;
import com.librarymanagementsystem.librarymanagementsystem.services.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private final AuthorRepo  authorRepo;
    private final ModelMapper modelMapper;

    public AuthorServiceImpl(AuthorRepo authorRepo, ModelMapper modelMapper) {
        this.authorRepo = authorRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addAuthor(AuthorSaveDto authorSaveDto) {
        Author author = new Author();
        author.setName(authorSaveDto.getName());
        authorRepo.save(author);
    }

    @Override
    public List<AuthorDto> getALlAuthors() {

        List<Author>  getAuthors= authorRepo.findAll();
        if(getAuthors.isEmpty()) {
            throw new ResourceAccessException("NO AUTHOR FOUND");
        }
        return getAuthors.stream()
                .map(author -> modelMapper.map(author,AuthorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void updateAuthor(AuthorUpdateDto authorUpdateDto) {
        //Checks the author exists by {id}
        Author author = authorRepo.findById(authorUpdateDto.getAuthorId())
                .orElseThrow(() -> new ResourceAccessException("AUTHOR NOT FOUND"));
        // Mapp the updated Dto to Author Entity
        modelMapper.map(authorUpdateDto,author);
        authorRepo.save(author);

    }

    @Override
    public boolean deleteAuthor(Integer id) {
        if(!authorRepo.existsById(id)) return false;
        authorRepo.deleteById(id);
        return true;
    }

}
