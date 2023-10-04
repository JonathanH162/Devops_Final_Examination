package com.example.devops_final_examination.bootstrap;


import com.example.devops_final_examination.Repositories.JokeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BootstrapDataIntegrationTest {

    JokeRepo jokeRepo;

    @Autowired
    public BootstrapDataIntegrationTest(JokeRepo jokeRepo) {

        this.jokeRepo = jokeRepo;
    }
    @Test
    public void repoHasDataTest() {

        assertThat(jokeRepo.jokeMap).isNotEmpty();
    }

    @Test
    public void repoFirstIterationIsMondayTest() {
        String monday = jokeRepo.jokeMap.get(0).toUpperCase();
        boolean containsMonday = monday.contains("MONDAY");

        assertTrue(containsMonday);
    }

    @Test
    public void repoDataIsLongEnoughTest() {

        assertEquals(7, jokeRepo.jokeMap.size());
    }


}