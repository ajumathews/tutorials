package com.tutorial.spring.mongodb.mongo;

import com.tutorial.spring.mongodb.model.Book;
import com.tutorial.spring.mongodb.repository.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
/*import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;*/

import java.util.List;

//@Testcontainers
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class BookRepositoryTest {

    //@Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @Autowired
    private BookRepository bookRepository;

    @AfterEach
    void cleanUp() {
        this.bookRepository.deleteAll();
    }

    @Test
    void shouldReturnListOfCustomerWithMatchingRate() {
        this.bookRepository.save(new Book(123, "java",123));


        List<Book> customers = bookRepository.findAll();

        Assertions.assertEquals(2, customers.size());
    }
}
