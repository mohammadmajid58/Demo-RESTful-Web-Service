package com.example.demo.restservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestGreetingController {

    @Autowired
    private MockMvc mockMvc;

    private void testGreeting(String url, String expected) throws Exception {
        this.mockMvc.perform(get(url)).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString(expected)));
    }

    @Test
    public void testGreeting() throws Exception {
        testGreeting("/greeting", "Hello, World!");

    }

    @Test
    public void testGreetingWithName() throws Exception {
        testGreeting("/greeting?name=Bob", "Hello, Bob!");
    }

}
