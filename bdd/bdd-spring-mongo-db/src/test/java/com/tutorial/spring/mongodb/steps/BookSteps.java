package com.tutorial.spring.mongodb.steps;

import com.tutorial.spring.mongodb.model.Book;
import com.tutorial.spring.mongodb.repository.BookRepository;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class BookSteps {

    @Autowired
    protected TestRestTemplate testRestTemplate;

    @Autowired
    private BookRepository bookRepository;

    private ResponseEntity<List> result;




    @When("the client call \\/books")
    public void theClientCallBooks() {
        this.bookRepository.save(new Book(123, "java",123));

        result = testRestTemplate.getForEntity("http://localhost:8080/books", List.class);    }

    @Then("the client recieves status code of {int}")
    public void theClientRecievesStatusCodeOf(int arg0) {
        Assert.assertEquals(arg0, result.getStatusCodeValue());
    }

    @And("the client gets all books")
    public void theClientGetsAllBooks() {
        Assert.assertEquals(1, result.getBody().size());
    }
}
