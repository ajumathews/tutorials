package com.tutorial.hexagonalarchitecture.repository;

import com.tutorial.hexagonalarchitecture.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {
}
