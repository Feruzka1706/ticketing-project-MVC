package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO,Long> implements TaskService {

    @Override
    public TaskDTO save(TaskDTO object) {
        if (object.getId() == null) {
            object.setId(UUID.randomUUID().getMostSignificantBits());
        }
        if (object.getTaskStatus() == null) {
            object.setTaskStatus(Status.OPEN);
        }

        if (object.getAssignedDate() == null) {
            object.setAssignedDate(LocalDate.now());
        }
        return super.save(object.getId(),object);
    }


    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public TaskDTO findById(Long taskId) {
        return super.findBydId(taskId);
    }


    @Override
    public void deleteById(Long taskId) {
         super.deleteById(taskId);
    }

    @Override
    public void update(TaskDTO object) {
        super.update(object.getId(),object);
    }


}
