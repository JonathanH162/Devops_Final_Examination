package com.example.devops_final_examination.controllers;

import com.example.devops_final_examination.Repositories.JokeRepo;
import com.example.devops_final_examination.service.JokeManipulator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JokeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JokeRepo jokeRepo;

    @Autowired
    private JokeManipulator jokeManipulator;

    @Test
    public void testGetWeeklyJokes() throws Exception {
        String expectedJoke = jokeRepo.jokeMap.toString();

        mockMvc.perform(get("/joke"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJoke));
    }

    @Test
    public void testGetTodaysJoke() throws Exception {
        String todaysDate = LocalDate.now().getDayOfWeek().toString();
        String expectedTodaysJoke = jokeManipulator.checkTodaysJoke(todaysDate);

        mockMvc.perform(get("/joke/today"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedTodaysJoke));
    }
}