package com.librarymanagementsystem.librarymanagementsystem.services.impl;


import com.librarymanagementsystem.librarymanagementsystem.dto.BorrowDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.BorrowSaveDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.BorrowUpdateDto;
import com.librarymanagementsystem.librarymanagementsystem.entity.*;
import com.librarymanagementsystem.librarymanagementsystem.repo.BookRepo;
import com.librarymanagementsystem.librarymanagementsystem.repo.BorrowRepo;
import com.librarymanagementsystem.librarymanagementsystem.repo.UserRepo;
import com.librarymanagementsystem.librarymanagementsystem.services.BorrowService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private  final BorrowRepo  borrowRepo;
    private final ModelMapper modelMapper;
    @Autowired
    private  final BookRepo bookRepo;
    private  final UserRepo userRepo;


    public BorrowServiceImpl(BorrowRepo borrowRepo, ModelMapper modelMapper, BookRepo bookRepo, UserRepo userRepo) {
        this.borrowRepo = borrowRepo;
        this.modelMapper = modelMapper;
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
    }


    @Override
    public BorrowDto addBorrow(BorrowSaveDto borrowSaveDto) {
        Book book = bookRepo.findById(borrowSaveDto.getBookId())
                .orElseThrow(() -> new RuntimeException("Author Not Found"));
        User user = userRepo.findById(borrowSaveDto.getUserId())
                .orElseThrow(() -> new RuntimeException("Publisher Not Found"));
        Borrow borrow = new Borrow();
        borrow.setBorrowDate(borrowSaveDto.getBorrowDate());
        borrow.setReturnDate(borrowSaveDto.getReturnDate());
        borrow.setBook(book);
        borrow.setUser(user);
        borrowRepo.save(borrow);
        BorrowDto borrowDto = modelMapper.map(borrow,BorrowDto.class);
        return borrowDto;

    }

    @Override
    public List<BorrowDto> getALlBorrows() {
        List<Borrow> borrow = borrowRepo.findAll();
        if(borrow.isEmpty()) throw new RuntimeException("Book Not Found");

        return borrow.stream()
                .map(b -> modelMapper.map(b, BorrowDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BorrowDto updateBorrow(BorrowUpdateDto borrowUpdateDto) {
        Borrow borrow = borrowRepo.findById(borrowUpdateDto.getBorrowId())
                .orElseThrow(() -> new RuntimeException("Book Not Found"));

        borrow.setBorrowDate(borrowUpdateDto.getBorrowDate());
        borrow.setReturnDate(borrowUpdateDto.getReturnDate());
        borrowRepo.save(borrow);
        BorrowUpdateDto updatedDto= modelMapper.map(borrow,BorrowUpdateDto.class);
        return modelMapper.map(updatedDto,BorrowDto.class);
    }
}
