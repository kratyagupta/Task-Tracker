package com.kratya.taskMngr.Mappers;

import com.kratya.taskMngr.domain.dto.TaskListDto;
import com.kratya.taskMngr.domain.entities.TaskList;

public interface TaskListMapper {
    TaskList fromDto(TaskListDto taskListDto);
    TaskListDto toDto(TaskList taskList);

}
