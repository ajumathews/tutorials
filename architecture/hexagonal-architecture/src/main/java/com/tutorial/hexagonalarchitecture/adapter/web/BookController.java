package com.tutorial.hexagonalarchitecture.adapter.web;

import com.tutorial.hexagonalarchitecture.adapter.BookDTO;
import com.tutorial.hexagonalarchitecture.application.port.in.BookServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookServicePort bookService;

    @PostMapping("/addBook")
    public String addBook(@RequestBody BookDTO bookDTOok) {
        return bookService.addBook(bookDTOok);
    }

    @GetMapping("/books")
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }


}
