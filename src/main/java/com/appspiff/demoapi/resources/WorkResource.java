package com.appspiff.demoapi.resources;

import com.appspiff.demoapi.model.Work;
import com.appspiff.demoapi.resources.dto.WorkDTO;
import com.appspiff.demoapi.resources.mappers.WorkMapper;
import com.appspiff.demoapi.services.WorkService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/work")
public class WorkResource {

    private final WorkService workService;
    private final WorkMapper workMapper;

    public WorkResource(WorkService workService, WorkMapper workMapper) {
        this.workService = workService;
        this.workMapper = workMapper;
    }

    @GetMapping(value = "/{id}")
    public WorkDTO getWork(@PathVariable long id) {
        return workMapper.toDTO(workService.findOne(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorkDTO create(@RequestBody WorkDTO dto){
        return workMapper.toDTO(workService.save(workMapper.toEntity(dto)));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WorkDTO update(@PathVariable( "id" ) Long id, @RequestBody Work work) {
        return workMapper.toDTO(workService.update(id,work));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id){
        workService.deleteOne(id);
    }

}
