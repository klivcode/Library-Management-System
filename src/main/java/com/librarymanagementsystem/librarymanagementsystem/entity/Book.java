package com.librarymanagementsystem.librarymanagementsystem.entity;


import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

import java.util.Set;


@RequiredArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id",length = 11,nullable = false)
    private Integer bookId;
    @Column(name = "title",length = 45,nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id",nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id",nullable = false)
    private Publisher publisher;

    @OneToMany(mappedBy = "book")
    private Set<Borrow> borrows;


    public Book(Integer bookId, String title, Author author, Publisher publisher) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public Book(String title, Author author, Publisher publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}

