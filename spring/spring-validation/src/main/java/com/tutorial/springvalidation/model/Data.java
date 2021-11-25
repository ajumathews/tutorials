package com.tutorial.springvalidation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class Data {

    @NotBlank(message = "name should not be empty")
    private String name;

    @NotBlank(message = "description should not be empty")
    private String description;
}
