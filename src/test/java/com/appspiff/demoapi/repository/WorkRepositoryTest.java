package com.appspiff.demoapi.repository;

import com.appspiff.demoapi.model.Work;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WorkRepositoryTest {

    @Autowired
    private ProjectRepository repository;

    @Test
    public void test_some(){
        Work paperino = new Work();
        paperino.setName("Paperino");
    }
}