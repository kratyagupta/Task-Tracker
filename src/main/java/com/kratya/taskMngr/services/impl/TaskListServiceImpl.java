package com.kratya.taskMngr.services.impl;

import com.kratya.taskMngr.domain.entities.TaskList;
import com.kratya.taskMngr.repo.TaskListRepo;
import com.kratya.taskMngr.services.TaskListService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskListServiceImpl implements TaskListService {
    private final TaskListRepo taskListRepo;

    public TaskListServiceImpl(TaskListRepo taskListRepo) {
        this.taskListRepo = taskListRepo;
    }

    @Override
    public List<TaskList> listTaskLists() {
        return taskListRepo.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {
        if(taskList.getId()!=null){
            throw new IllegalArgumentException("Task List already has an ID!");
        }
        if(taskList.getTitle().isBlank() || taskList.getTitle()==null){
            throw new IllegalArgumentException("The task list title must be present!");
        }
        LocalDateTime now  = LocalDateTime.now();
        return taskListRepo.save(new TaskList(
                null,
                taskList.getTitle(),
                taskList.getDescription(),
                null,
                now,
                now
        ));
    }

    @Override
    public Optional<TaskList> getTaskList(UUID id) {
        return taskListRepo.findById(id);
    }

    @Override
    public TaskList updateTaskList(UUID taskListId, TaskList taskList) {
        if(taskList.getId()==null){
            throw new IllegalArgumentException("Task List must have an ID!");
        }
        if(!Objects.equals(taskList.getId(),taskListId)){
            throw new IllegalArgumentException("Attempt to change task list ID is not permitted!");
        }
        TaskList existingTaskList =  taskListRepo.findById(taskListId).orElseThrow(()->
                new IllegalArgumentException("Task list not found!"));

        existingTaskList.setTitle(taskList.getTitle());
        existingTaskList.setDescription(taskList.getDescription());
        existingTaskList.setUpdated(LocalDateTime.now());
        return taskListRepo.save(existingTaskList);
    }
}
