package com.appspiff.demoapi.services;

import com.appspiff.demoapi.model.Work;
import com.appspiff.demoapi.repository.WorkRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkService {

    private WorkRepository workRepository;

    public WorkService(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    public Work save(Work work){
        return workRepository.save(work);
    }

    public List<Work> list(){
        return workRepository.findAll();
    }
}
