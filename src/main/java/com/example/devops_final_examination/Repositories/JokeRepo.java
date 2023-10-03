package com.example.devops_final_examination.Repositories;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class JokeRepo {

    public  Map<Integer, String> getJokeMap() {
        return jokeMap;
    }

    public Map<Integer, String> jokeMap = new HashMap<>();

}
