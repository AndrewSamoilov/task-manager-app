package com.andrewsmv.taskmanagerapp.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Null(message = "Id must be null")
    private Long id;

    @NotNull(message = "Email must be not null")
    @Email(message = "Email is invalid")
    private String email;

    @Null(message = "Created date must be null")
    private LocalDate createdDate;

    @Null(message = "Last modified date must be null")
    private LocalDate lastModifiedDate;
}
