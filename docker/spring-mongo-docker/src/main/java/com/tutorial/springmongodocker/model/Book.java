package com.tutorial.springmongodocker.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "books")
public class Book {

    private int id;
    private String name;
    private String authorName;
}
