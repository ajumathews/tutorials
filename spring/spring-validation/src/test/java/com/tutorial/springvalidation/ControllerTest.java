package com.tutorial.springvalidation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.springvalidation.model.Data;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = TestController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TestService testService;


    @Test
    public void test() throws Exception {
        Mockito.when(testService.test()).thenReturn("hello");
        mockMvc.perform(get("/getData")).andExpect(status().isBadRequest());
    }

    @Test
    public void testSuccess() throws Exception {
        mockMvc.perform(get("/getData").param("data", "namae")).andExpect(status().is2xxSuccessful());
    }


    @Test
    public void test2() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        Data data = new Data("1212", "");
        mockMvc.perform(post("/createData")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(data)))
                .andExpect(status().isBadRequest());
    }


    @Test
    public void test3() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        Data data = new Data("1212", " ");
        mockMvc.perform(post("/createData")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(data)))
                .andExpect(status().isBadRequest());
    }


    @Test
    public void test4() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        Data data = new Data("1212", "sdsd");
        mockMvc.perform(post("/createData")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(data)))
                .andExpect(status().isOk());
    }


    @Test
    public void test5() throws Exception {
        mockMvc.perform(get("/number")).andExpect(status().isBadRequest());
    }

    @Test
    public void test6() throws Exception {
        mockMvc.perform(get("/boolean?isValid=truesdsd")).andExpect(status().isBadRequest());
    }

}
