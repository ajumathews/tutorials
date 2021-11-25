package com.tutorial.bddsprinbootboot.bdd.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

public class HelloWorldStepDef {

    @Autowired
    protected TestRestTemplate testRestTemplate;

    private ResponseEntity<String> result;


    @Then("the client recieves status code of {int}")
    public void theClientRecievesStatusCodeOf(int arg0) {
        Assert.assertEquals(arg0, result.getStatusCodeValue());
    }


    @When("the client call \\/hello")
    public void theClientCallHello() {
        result = testRestTemplate.getForEntity("http://localhost:8080/hello", String.class);
    }

    @And("the client recieves message hello")
    public void theClientRecievesMessageHello() {
        Assert.assertEquals("hello", result.getBody());
    }
}
