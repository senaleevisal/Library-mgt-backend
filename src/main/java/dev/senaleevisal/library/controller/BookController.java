package dev.senaleevisal.library.controller;

import dev.senaleevisal.library.dao.Book;
import dev.senaleevisal.library.dto.ResponseBody.ResponseBody;
import dev.senaleevisal.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/library/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<ResponseBody> addBook(@RequestBody Book book) {
        Book addedBook = bookService.addBook(book);
        ResponseBody responseBody = new ResponseBody();
        responseBody.addBook("book", addedBook);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseBody> removeBook(@PathVariable int id) {
        boolean isRemoved = bookService.removeBook(id);
        ResponseBody responseBody = new ResponseBody();
        if (isRemoved) {
            responseBody.addResponse("status", "Book removed successfully");
            return ResponseEntity.ok(responseBody);
        } else {
            responseBody.addResponse("status", "Book not found");
            return ResponseEntity.status(404).body(responseBody);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBody> updateBook(@PathVariable int id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        ResponseBody responseBody = new ResponseBody();
        if (updatedBook != null) {
            responseBody.addBook("book", updatedBook);
            return ResponseEntity.ok(responseBody);
        } else {
            responseBody.addResponse("status", "Book not found");
            return ResponseEntity.status(404).body(responseBody);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ResponseBody> getBookByName(@PathVariable String name) {
        Book book = bookService.getBookByName(name);
        ResponseBody responseBody = new ResponseBody();
        if (book != null) {
            responseBody.addBook("book", book);
            return ResponseEntity.ok(responseBody);
        } else {
            responseBody.addResponse("status", "Book not found");
            return ResponseEntity.status(404).body(responseBody);
        }
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<ResponseBody> getBookByIsbn(@PathVariable String isbn) {
        Book book = bookService.getBookByIsbn(isbn);
        ResponseBody responseBody = new ResponseBody();
        if (book != null) {
            responseBody.addBook("book", book);
            return ResponseEntity.ok(responseBody);
        } else {
            responseBody.addResponse("status", "Book not found");
            return ResponseEntity.status(404).body(responseBody);
        }
    }
}