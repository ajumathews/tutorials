package com.tutorial.hexagonalarchitecture.application.port.out;

import com.tutorial.hexagonalarchitecture.adapter.BookDTO;

import java.util.List;

public interface BookPersistencePort {
    String addBook(BookDTO bookDTO);

    List<BookDTO> getAllBooks();

}
