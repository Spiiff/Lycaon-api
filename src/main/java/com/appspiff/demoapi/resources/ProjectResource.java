package com.appspiff.demoapi.resources;

import com.appspiff.demoapi.model.Project;
import com.appspiff.demoapi.resources.dto.ProjectDTO;
import com.appspiff.demoapi.resources.mappers.ProjectMapper;
import com.appspiff.demoapi.services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectResource {

    private final ProjectService projectService;

    private final ProjectMapper projectMapper;

    public ProjectResource(ProjectService projectService, ProjectMapper projectMapper) {
        this.projectService = projectService;
        this.projectMapper = projectMapper;
    }

    @GetMapping(value = "/{id}")
    public ProjectDTO getProject(@PathVariable long id) {
        return projectMapper.toDTO(projectService.findOne(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectDTO create(@RequestBody ProjectDTO dto){
        return projectMapper.toDTO(projectService.save(projectMapper.toEntity(dto)));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectDTO update(@PathVariable( "id" ) Long id, @RequestBody Project project) {
        return projectMapper.toDTO(projectService.update(id,project));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id){
        projectService.deleteOne(id);
    }
}
