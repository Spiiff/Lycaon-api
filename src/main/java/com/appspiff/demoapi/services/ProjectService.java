package com.appspiff.demoapi.services;

import com.appspiff.demoapi.model.Project;
import com.appspiff.demoapi.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> list() {
        return projectRepository.findAll();
    }

    public Project findOne(long id) {

        Optional<Project> optional = projectRepository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("entity not found"); //todo
        }
        return optional.get();
    }

    public void deleteOne(Long id) {
        projectRepository.deleteById(id);
    }

    public Project update(Long id, Project project) {
        Optional<Project> optional = projectRepository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("entity not found"); //todo
        }
        return projectRepository.save(project);
    }
}
