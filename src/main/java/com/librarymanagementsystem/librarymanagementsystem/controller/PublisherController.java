package com.librarymanagementsystem.librarymanagementsystem.controller;


import com.librarymanagementsystem.librarymanagementsystem.dto.PublisherDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.PublisherSaveDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.PublisherUpdateDto;
import com.librarymanagementsystem.librarymanagementsystem.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/publisher")
public class PublisherController {


    @Autowired
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }
    
    @PostMapping(path = "/save")
    public ResponseEntity<String> savePublisher(@RequestBody PublisherSaveDto publisherSaveDto) {
        publisherService.addPublisher(publisherSaveDto);
        return ResponseEntity.ok("Inserted Publisher Successfully");
    }

    @GetMapping(path = "/getAllPublisher")
    public ResponseEntity<List<PublisherDto>> getAllPublisher() {
        List<PublisherDto> getALlPublisher =  publisherService.getPublisher();
        return ResponseEntity.ok(getALlPublisher);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<PublisherUpdateDto> updatePublisher(@RequestBody PublisherUpdateDto publisherUpdateDto) {
        PublisherUpdateDto updatedPublisher= publisherService.updatePublisher(publisherUpdateDto);
        return ResponseEntity.ok(updatedPublisher);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deletePublisher(@PathVariable(value = "id") Integer id) {
        boolean authorPublisher=publisherService.deleteAuthor(id);
        if(authorPublisher){
            return ResponseEntity.ok("Publisher deleted successfully");
        }
        return ResponseEntity.badRequest().build();
    }

}
