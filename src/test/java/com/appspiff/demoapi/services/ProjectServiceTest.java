package com.appspiff.demoapi.services;

import com.appspiff.demoapi.model.Project;
import com.appspiff.demoapi.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectRepository projectRepository;


    @Test
    public void whenAppStart_createProject() {
        List<Project> project = projectService.list();

        assertEquals(0, project.size());
    }

    @Test
    void testSave() {
        Project project = new Project();
        project.setName("Test");

        Project save = projectService.save(project);
        Optional<Project> find = projectRepository.findById(save.getId());

        assertEquals("Test", find.get().getName());
    }

    @Test
    void list() {
    }
}