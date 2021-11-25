package com.tutorial.springvalidation;

import com.tutorial.springvalidation.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
public class TestController extends BaseController{

    @Autowired
    private TestService testService;

    @GetMapping(value = "/getData")
    public String getData(
            @RequestParam(value = "data", required = false) @NotBlank(message = "{data.errorMessage}") String data) {
        return data;
    }

    @PostMapping(value = "/createData", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createData(
            @RequestBody @Valid Data data) {
        sayHello();
        testService.test();
        return "created";
    }


    @GetMapping(value = "/number")
    public Integer testNumber(@RequestParam(value = "age") @PositiveOrZero(message = "Not a number") Integer age) {
         return age;
    }

    @GetMapping(value = "/boolean")
    public Boolean testNumber(@RequestParam(value = "isValid", required = false) @NotNull Boolean isValid) {
        return isValid;
    }


    @PostMapping(value = "/collection")
    public String testNumber( @NotEmpty @Valid @RequestBody List<Data> dataList) {
        return dataList.stream().map(d->d.getDescription()).collect(Collectors.joining(","));
    }
}
