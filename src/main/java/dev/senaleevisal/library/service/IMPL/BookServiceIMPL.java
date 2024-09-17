// src/main/java/dev/senaleevisal/library/service/IMPL/BookServiceIMPL.java
package dev.senaleevisal.library.service.IMPL;

import dev.senaleevisal.library.dao.Book;
import dev.senaleevisal.library.dto.BookEntity;
import dev.senaleevisal.library.repository.BookRepository;
import dev.senaleevisal.library.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceIMPL implements BookService {

    private final BookRepository bookRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public BookServiceIMPL(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Book addBook(Book book) {
        BookEntity bookEntity = modelMapper.map(book, BookEntity.class);
        BookEntity savedEntity = bookRepository.save(bookEntity);
        return modelMapper.map(savedEntity, Book.class);
    }

    @Override
    public boolean removeBook(int id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Book updateBook(int id, Book book) {
        if (bookRepository.existsById(id)) {
            BookEntity bookEntity = modelMapper.map(book, BookEntity.class);
            bookEntity.setId(id);
            BookEntity updatedEntity = bookRepository.save(bookEntity);
            return modelMapper.map(updatedEntity, Book.class);
        }
        return null;
    }

    @Override
    public Book getBookByName(String name) {
        BookEntity bookEntity = bookRepository.findByTitle(name);
        return modelMapper.map(bookEntity,Book.class);
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        BookEntity bookEntity = bookRepository.findByIsbn(isbn);
        return modelMapper.map(bookEntity,Book.class);
    }
}