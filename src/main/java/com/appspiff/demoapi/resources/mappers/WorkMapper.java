package com.appspiff.demoapi.resources.mappers;

import com.appspiff.demoapi.model.Work;
import com.appspiff.demoapi.resources.dto.WorkDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ProjectMapper.class})
public interface WorkMapper {

    @Mapping(source = "project.id", target = "projectId")
    WorkDTO toDTO(Work work);

    @Mapping(source = "projectId", target = "project")
    Work toEntity(WorkDTO dto);
}
