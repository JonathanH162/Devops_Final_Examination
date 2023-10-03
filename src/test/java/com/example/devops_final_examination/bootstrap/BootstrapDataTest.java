package com.example.devops_final_examination.bootstrap;


import com.example.devops_final_examination.Repositories.JokeRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BootstrapDataTest {

    @Mock
    private JokeRepo jokeRepo;

    @Mock
    private Map<Integer, String> mockMenuMap;

    @InjectMocks
    private BootstrapData bootstrapData;

    @Test
    void testJokeReader() {
        when(jokeRepo.getJokeMap()).thenReturn(mockMenuMap);
        bootstrapData.jokeReader();
        verify(mockMenuMap, times(7)).put(anyInt(), anyString());
    }
}

