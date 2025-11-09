package com.librarymanagementsystem.librarymanagementsystem.controller;


import com.librarymanagementsystem.librarymanagementsystem.dto.*;
import com.librarymanagementsystem.librarymanagementsystem.dto.response.ResponseDto;
import com.librarymanagementsystem.librarymanagementsystem.entity.Borrow;
import com.librarymanagementsystem.librarymanagementsystem.services.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/borrow")
public class BorrowController {
    @Autowired
    private final BorrowService borrowService;

    @PostMapping(path = "/save")
    public ResponseEntity<ResponseDto> saveBorrow(@RequestBody BorrowSaveDto  borrowSaveDto) {
        BorrowDto borrowDto = borrowService.addBorrow(borrowSaveDto);
        if (borrowDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto("Successfully Added !","SUCCESS",borrowDto));
        }
        return ResponseEntity.ok(new ResponseDto("FAILED TO ADDED !","FAILURE",null));
    }

    @GetMapping(path = "/getAllBorrows")
    public ResponseEntity<List<BorrowDto>> getAllBorrows() {
        List<BorrowDto> getBorrows= borrowService.getALlBorrows();
        return ResponseEntity.ok(getBorrows);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<ResponseDto> updateBorrow(@RequestBody BorrowUpdateDto borrowUpdateDto) {
        BorrowDto updatedDto= borrowService.updateBorrow(borrowUpdateDto);

        if(updatedDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDto("Borrow Not Found","FAILED",null));
        }

        return ResponseEntity.ok(
                new ResponseDto("Borrow updated successfully", "SUCCESS", updatedDto));
    }
    }


