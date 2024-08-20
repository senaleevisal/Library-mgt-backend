package dev.senaleevisal.library.service;

import dev.senaleevisal.library.dao.Book;

public interface BookService {
    Book addBook(Book book);

    boolean removeBook(int id);

    Book updateBook(int id, Book book);

    Book getBookByName(String name);

    Book getBookByIsbn(String isbn);
}
