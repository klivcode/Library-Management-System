package com.librarymanagementsystem.librarymanagementsystem.services.impl;

import com.librarymanagementsystem.librarymanagementsystem.dto.PublisherDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.PublisherSaveDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.PublisherUpdateDto;
import com.librarymanagementsystem.librarymanagementsystem.entity.Publisher;
import com.librarymanagementsystem.librarymanagementsystem.repo.PublisherRepo;
import com.librarymanagementsystem.librarymanagementsystem.services.PublisherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private final PublisherRepo  publisherRepo;

    @Autowired
    private final ModelMapper modelMapper;

    public PublisherServiceImpl(PublisherRepo publisherRepo, ModelMapper modelMapper) {
        this.publisherRepo = publisherRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addPublisher(PublisherSaveDto publisherSaveDto) {
        Publisher publisher = modelMapper.map(publisherSaveDto, Publisher.class);
        publisherRepo.save(publisher);
    }

    @Override
    public List<PublisherDto> getPublisher() {
        List<Publisher> getALlPublisher = publisherRepo.findAll();
        if(getALlPublisher.isEmpty()) {throw  new ResourceAccessException("No publisher found");
        }

        return getALlPublisher.stream()
                .map(publisher -> modelMapper.map(publisher,PublisherDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PublisherUpdateDto updatePublisher(PublisherUpdateDto publisherUpdateDto) {
        Publisher publisher = publisherRepo.findById(publisherUpdateDto.getPublisherId())
                .orElseThrow(()-> new ResourceAccessException("Publisher not found"));

        modelMapper.map(publisherUpdateDto,publisher);
        publisherRepo.save(publisher);
        return modelMapper.map(publisherUpdateDto,PublisherUpdateDto.class);
    }

    @Override
    public boolean deleteAuthor(Integer id) {
        if(!publisherRepo.existsById(id)) return false;
        publisherRepo.deleteById(id);
        return true;
    }
}
