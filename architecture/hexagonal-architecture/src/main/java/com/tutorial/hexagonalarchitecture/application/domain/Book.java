package com.tutorial.hexagonalarchitecture.application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "book")
public class Book {

    @Id private int id;
    private String name;
    private int price;
}
