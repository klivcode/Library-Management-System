package com.librarymanagementsystem.librarymanagementsystem.services;

import com.librarymanagementsystem.librarymanagementsystem.dto.BorrowDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.BorrowSaveDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.BorrowUpdateDto;

import java.util.List;

public interface BorrowService {
    BorrowDto addBorrow(BorrowSaveDto borrowSaveDto);

    List<BorrowDto> getALlBorrows();

    BorrowDto updateBorrow(BorrowUpdateDto borrowUpdateDto);
}
