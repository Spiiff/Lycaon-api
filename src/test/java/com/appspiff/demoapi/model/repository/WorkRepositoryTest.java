package com.appspiff.demoapi.model.repository;

import com.appspiff.demoapi.model.Project;
import com.appspiff.demoapi.model.Work;
import com.appspiff.demoapi.repository.ProjectRepository;
import com.appspiff.demoapi.repository.WorkRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WorkRepositoryTest {

    @Autowired
    private WorkRepository workRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void test_saveandFindWork() {
        Project project = new Project();
        Work paperino = new Work();
        paperino.setProject(project);

        paperino.setName("Paperino");
        paperino.setUser("Pippo");
        paperino.setHours(5);
        paperino.setDate("12/06/2020");
        paperino.setDescription("temp-work description");

        projectRepository.saveAndFlush(project);
        workRepository.saveAndFlush(paperino);
        Optional<Work> work = workRepository.findById(paperino.getId());

        assertEquals("Paperino", work.get().getName());
    }

    @Test
    public void test_editWork(){

    }
}