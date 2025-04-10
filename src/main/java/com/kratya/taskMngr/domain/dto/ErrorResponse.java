package com.kratya.taskMngr.domain.dto;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
