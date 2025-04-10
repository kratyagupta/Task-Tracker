package com.kratya.taskMngr.domain.dto;

import com.kratya.taskMngr.domain.entities.TaskPriority;
import com.kratya.taskMngr.domain.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status){
}
