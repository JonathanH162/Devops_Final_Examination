package com.example.devops_final_examination.controllers;

import com.example.devops_final_examination.Repositories.JokeRepo;
import com.example.devops_final_examination.service.JokeManipulator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class JokeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JokeRepo jokeRepo;

    @MockBean
    private JokeManipulator jokeManipulator;



    @Test
    public void getTodaysJokeTest() throws Exception {
        String todaysDate = LocalDate.now().getDayOfWeek().toString();
        String expectedJoke = "Todays Joke";
        when(jokeManipulator.checkTodaysJoke(todaysDate)).thenReturn(expectedJoke);

        mockMvc.perform(get("/joke/today"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedJoke));
    }
    @Test
    public void getWeekJokeTest() throws Exception {
        Map<Integer, String> expectedJoke = new HashMap<>();
        expectedJoke.put(0,"Monday");
        expectedJoke.put(1,"Tuesday");
        when(jokeRepo.getJokeMap()).thenReturn(expectedJoke);
        String expectedMenuString = expectedJoke.toString();
        mockMvc.perform(get("/joke"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedMenuString));
    }
}
