package com.example.devops_final_examination.service;

import com.example.devops_final_examination.Repositories.JokeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JokeManipulatorImplements implements JokeManipulator {

    JokeRepo jokeRepo;
    @Autowired
    public JokeManipulatorImplements(JokeRepo jokeRepo) {
        this.jokeRepo = jokeRepo;
    }

    @Override
    public String checkTodaysJoke(String date) {
        Weekdays weekdays = Weekdays.valueOf(date);
        return switch(weekdays) {
            case MONDAY  -> jokeRepo.jokeMap.get(0);
            case TUESDAY -> jokeRepo.jokeMap.get(1);
            case WEDNESDAY -> jokeRepo.jokeMap.get(2);
            case THURSDAY -> jokeRepo.jokeMap.get(3);
            case FRIDAY -> jokeRepo.jokeMap.get(4);
            case SATURDAY -> jokeRepo.jokeMap.get(5);
            case SUNDAY -> jokeRepo.jokeMap.get(6);
        };

    }
}
