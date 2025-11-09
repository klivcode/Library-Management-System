package com.librarymanagementsystem.librarymanagementsystem.services.impl;

import com.librarymanagementsystem.librarymanagementsystem.dto.BookDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.BookSaveDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.BookUpdateDto;
import com.librarymanagementsystem.librarymanagementsystem.entity.Author;
import com.librarymanagementsystem.librarymanagementsystem.entity.Book;
import com.librarymanagementsystem.librarymanagementsystem.entity.Publisher;
import com.librarymanagementsystem.librarymanagementsystem.repo.AuthorRepo;
import com.librarymanagementsystem.librarymanagementsystem.repo.BookRepo;
import com.librarymanagementsystem.librarymanagementsystem.repo.PublisherRepo;
import com.librarymanagementsystem.librarymanagementsystem.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private final BookRepo  bookRepo;
    private final AuthorRepo authorRepo;
    private final PublisherRepo publisherRepo;
    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepo bookRepo, AuthorRepo authorRepo, PublisherRepo publisherRepo, ModelMapper modelMapper) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.publisherRepo = publisherRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addBook(BookSaveDto bookSaveDto) {
        Author author = authorRepo.findById(bookSaveDto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author Not Found"));
        Publisher publisher = publisherRepo.findById(bookSaveDto.getPublisherId())
                .orElseThrow(() -> new RuntimeException("Publisher Not Found"));
        Book book = new Book();
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setTitle(bookSaveDto.getTitle());
        bookRepo.save(book);
    }

    @Override
    public List<BookDto> getAllBook() {
        List<Book> books = bookRepo.findAll();
        if(books.isEmpty()) throw new RuntimeException("Book Not Found");

        return books.stream()
                .map(book -> modelMapper.map(book,BookDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto updateBook(BookUpdateDto bookUpdateDto) {
        Book book = bookRepo.findById(bookUpdateDto.getBookId())
                .orElseThrow(() -> new RuntimeException("Book Not Found"));

        book.setTitle(bookUpdateDto.getTitle());
        bookRepo.save(book);

        // Save Entity to Dto to show
        BookDto bookDto = new BookDto(
                book.getBookId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher()
        );
        return bookDto;
    }

    @Override
    public boolean deleteBook(Integer id) {
        if(!bookRepo.existsById(id)) throw new RuntimeException("Book Not Found");
        bookRepo.deleteById(id);
        return true;
    }

}
