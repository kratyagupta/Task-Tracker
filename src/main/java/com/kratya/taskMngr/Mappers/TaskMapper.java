package com.kratya.taskMngr.Mappers;

import com.kratya.taskMngr.domain.dto.TaskDto;
import com.kratya.taskMngr.domain.entities.Task;

public interface TaskMapper {
    Task fromDto(TaskDto taskDto);
    TaskDto toDto(Task task);
}
