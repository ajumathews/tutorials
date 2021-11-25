package com.tutorial.hexagonalarchitecture.application.service;

import com.tutorial.hexagonalarchitecture.adapter.BookDTO;
import com.tutorial.hexagonalarchitecture.application.port.out.BookPersistencePort;
import com.tutorial.hexagonalarchitecture.application.port.in.BookServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookServicePort {

    @Autowired
    private BookPersistencePort bookPersistencePort;

    @Override
    public String addBook(BookDTO bookRequest) {
        return bookPersistencePort.addBook(bookRequest);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookPersistencePort.getAllBooks();
    }
}
