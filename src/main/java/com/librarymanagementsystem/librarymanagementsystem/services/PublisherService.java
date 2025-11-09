package com.librarymanagementsystem.librarymanagementsystem.services;

import com.librarymanagementsystem.librarymanagementsystem.dto.PublisherDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.PublisherSaveDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.PublisherUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PublisherService {
    void addPublisher(PublisherSaveDto publisherSaveDto);

    List<PublisherDto> getPublisher();

    PublisherUpdateDto updatePublisher(PublisherUpdateDto publisherSaveDto);

    boolean deleteAuthor(Integer id);
}
