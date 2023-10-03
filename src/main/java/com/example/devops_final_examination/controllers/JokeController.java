package com.example.devops_final_examination.controllers;


import com.example.devops_final_examination.Repositories.JokeRepo;
import com.example.devops_final_examination.service.JokeManipulator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/joke")
public class JokeController {

    JokeRepo jokeRepo;

    JokeManipulator jokeManipulator;

    public JokeController(JokeRepo jokeRepo, JokeManipulator jokeManipulator) {
        this.jokeRepo = jokeRepo;
        this.jokeManipulator = jokeManipulator;
    }

    @GetMapping
    public String getWeeklyJoke() {
        return jokeRepo.getJokeMap().toString();
    }

    @GetMapping("/today")
    public String getTodaysJoke() {
        return jokeManipulator.checkTodaysJoke(LocalDate.now().getDayOfWeek().toString());
    }

}
