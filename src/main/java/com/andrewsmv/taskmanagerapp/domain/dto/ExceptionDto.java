package com.andrewsmv.taskmanagerapp.domain.dto;

import lombok.Data;

@Data
public class ExceptionDto {
    private Integer httpStatus;
    private String message;
}
