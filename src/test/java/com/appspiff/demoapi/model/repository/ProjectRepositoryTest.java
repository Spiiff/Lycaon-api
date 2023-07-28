package com.appspiff.demoapi.model.repository;
import com.appspiff.demoapi.model.Project;
import com.appspiff.demoapi.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectRepositoryTest{

    @Autowired
    private ProjectRepository repository;
    @Test
    public void test_getReferenceByName(){
        Project pippo = new Project();
        pippo.setName("Pippo");
        pippo.setDescription("temp description");
        repository.saveAndFlush(pippo);
        Optional<Project> project = repository.findById(pippo.getId());

        assertEquals("Pippo", project.get().getName());
        assertEquals("temp description", project.get().getDescription());
    }

}