package com.appspiff.demoapi.services;
import com.appspiff.demoapi.model.Work;
import com.appspiff.demoapi.repository.WorkRepository;
import com.appspiff.demoapi.resources.dto.WorkDTO;
import com.appspiff.demoapi.resources.mappers.WorkMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WorkService {

    private WorkRepository workRepository;
    private WorkMapper workMapper;

    public WorkService(WorkRepository workRepository, WorkMapper workMapper) {
        this.workRepository = workRepository;
        this.workMapper = workMapper;
    }

    public Work save(Work work){
        return workRepository.save(work);
    }

    public List<Work> list(){
        return workRepository.findAll();
    }

    public Work findOne(long id){

        Optional<Work> optional = workRepository.findById(id);
        if(!optional.isPresent()){
            throw new RuntimeException("entity not found"); //todo
        }
        return optional.get();
    }

    public void deleteOne(Long id) {
        workRepository.deleteById(id);
    }

    public Work update(long id, WorkDTO dto) {
        Optional<Work> optional = workRepository.findById(id);
        if(!optional.isPresent()){
            throw new RuntimeException("entity not found"); //todo
        }
        return workRepository.save(workMapper.toEntity(dto));
    }

    public List<Work> findByProjectId(long id) {
        return workRepository.findByProjectId(id);
    }
}
