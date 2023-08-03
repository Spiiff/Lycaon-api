package com.appspiff.demoapi.services;

import com.appspiff.demoapi.model.Project;
import com.appspiff.demoapi.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project save(Project project){
        return projectRepository.save(project);
    }

    public List<Project> list(){
       return projectRepository.findAll();
    }
}
