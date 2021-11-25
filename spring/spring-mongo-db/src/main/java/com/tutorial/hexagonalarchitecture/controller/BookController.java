package com.tutorial.hexagonalarchitecture.controller;

import com.tutorial.hexagonalarchitecture.model.Book;
import com.tutorial.hexagonalarchitecture.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/addBook")
    public String addBook(@RequestBody Book book) {
        bookRepository.save(book);
        return "Added " + book.getName();
    }

    @GetMapping("/books")
    public List<Book> getAll() {
        return bookRepository.findAll();
    }


    @GetMapping("/books/{id}")
    public Book getAll(@PathVariable("id") int id) {
        return bookRepository.findById(id).orElse(null);
    }


    @DeleteMapping("/books/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        bookRepository.deleteById(id);
        return "Book deleted " + id;
    }


}
