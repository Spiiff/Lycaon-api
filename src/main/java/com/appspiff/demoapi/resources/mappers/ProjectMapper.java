package com.appspiff.demoapi.resources.mappers;

import com.appspiff.demoapi.model.Project;
import com.appspiff.demoapi.repository.ProjectRepository;
import com.appspiff.demoapi.resources.dto.ProjectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ProjectMapper {
    @Autowired
    ProjectRepository projectRepository;

    public abstract ProjectDTO toDTO(Project project);

    public abstract Project toEntity(ProjectDTO dto);

    public Project fromId(Long id) throws Exception {
        if(id==null){
            return null;
        }
        return projectRepository.findById(id).orElseThrow(() -> new Exception("Err no project found"));
    }
}
