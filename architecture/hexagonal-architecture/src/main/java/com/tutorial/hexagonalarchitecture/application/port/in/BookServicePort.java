package com.tutorial.hexagonalarchitecture.application.port.in;

import com.tutorial.hexagonalarchitecture.adapter.BookDTO;

import java.util.List;

public interface BookServicePort {
     String addBook(BookDTO bookRequest);
     List<BookDTO> getAllBooks();
}
