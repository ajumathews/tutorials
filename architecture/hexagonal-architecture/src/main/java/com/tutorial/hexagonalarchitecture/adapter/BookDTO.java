package com.tutorial.hexagonalarchitecture.adapter;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class BookDTO {

    private int id;
    private String name;
    private int price;
}