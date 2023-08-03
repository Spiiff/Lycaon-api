package com.appspiff.demoapi.model.repository;

import com.appspiff.demoapi.model.Project;
import com.appspiff.demoapi.repository.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository repository;

    @BeforeEach
    public void refreshDB(){  // refresh db evry test
        repository.deleteAll();
    }

    @Test
    public void test_saveandFindProject() {
        Project pippo = new Project();

        pippo.setName("Pippo");
        pippo.setDescription("temp-project description");

        repository.saveAndFlush(pippo);
        Optional<Project> project = repository.findById(pippo.getId());

        assertEquals("Pippo", project.get().getName());
        assertEquals("temp-project description", project.get().getDescription());

    }

    @Test
    public void test_editProject(){
        Project projedit = new Project();

        projedit.setName("Pluto");
        projedit.setDescription("temp desc");

        repository.save(projedit);
        projedit.setName("Asd");
        repository.save(projedit);

        assertEquals("Asd", projedit.getName());
    }

    @Test
    public void test_deleteProject(){
        Project projdel = new Project();
        Project proj2= new Project();

        //projdel.setName("Paperino");

        repository.save(projdel);
        repository.save(proj2);
        repository.delete(projdel);
        List<Project> result = repository.findAll();

        assertEquals(result.size(),1);
        assertNotEquals(result.size(),0);
        assertNotEquals(result.size(),2);

    }
}