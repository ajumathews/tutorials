package com.tutorial.hexagonalarchitecture.adapter.repository;

import com.tutorial.hexagonalarchitecture.application.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {
}
