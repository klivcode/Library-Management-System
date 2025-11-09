package com.librarymanagementsystem.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;


@RequiredArgsConstructor
@Entity
@Table(name = "borrow",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = {"book_id", "user_id"}, name = "unique_book_user")
        }

)
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id",length = 11,nullable = false)
    private Integer borrowId;

    private LocalDate borrowDate;

    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private  User user;


    public Borrow(Integer borrowId, LocalDate borrowDate, LocalDate returnDate, Book book, User user) {
        this.borrowId = borrowId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.book = book;
        this.user = user;
    }

    public Borrow(LocalDate borrowDate, LocalDate returnDate, Book book, User user) {
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.book = book;
        this.user = user;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
