package com.appspiff.demoapi.services;

import com.appspiff.demoapi.model.Work;
import com.appspiff.demoapi.repository.ProjectRepository;
import com.appspiff.demoapi.repository.WorkRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WorkServiceTest {

    @Autowired
    private WorkService workService;
    @Autowired
    private WorkRepository workRepository;

    @Test
    public void whenAppStart_createWork(){
        //List<Work> work = projectService.list();

        //assertEquals(0, work.size());
    }

}