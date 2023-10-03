package com.example.devops_final_examination.bootstrap;

import com.example.devops_final_examination.Repositories.JokeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class BootstrapData implements CommandLineRunner {

    String filePath = "/documents/jokes.txt";
    JokeRepo jokeRepo;

    @Autowired
    public BootstrapData(JokeRepo jokeRepo) {
        this.jokeRepo = jokeRepo;
    }



    public void jokeReader() {
        try (InputStream inputStream = getClass().getResourceAsStream(filePath)) {
            assert inputStream != null;
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

                bufferedReader.lines()
                        .forEachOrdered(line -> jokeRepo.getJokeMap().put(jokeRepo.getJokeMap().size(), line));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void run(String... args) {
        jokeReader();
    }
}

