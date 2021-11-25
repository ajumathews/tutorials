package com.tutorial.hexagonalarchitecture.adapter.db;

import com.tutorial.hexagonalarchitecture.adapter.BookDTO;
import com.tutorial.hexagonalarchitecture.application.domain.Book;
import com.tutorial.hexagonalarchitecture.application.port.out.BookPersistencePort;
import com.tutorial.hexagonalarchitecture.adapter.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookMongoAdapter implements BookPersistencePort {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public String addBook(BookDTO bookDTO) {
        Book book = new Book(bookDTO.getId(), bookDTO.getName(), bookDTO.getPrice());
        bookRepository.save(book);
        return "Book Added " + book.getName();
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(book -> new BookDTO(book.getId(), book.getName(), book.getPrice()))
                .collect(Collectors.toList());
    }

}
