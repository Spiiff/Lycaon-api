package com.appspiff.demoapi.repository;

import com.appspiff.demoapi.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {

    List<Work> findByProjectId(long id);
}
