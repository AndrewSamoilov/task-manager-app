package com.andrewsmv.taskmanagerapp.testutils;

import com.andrewsmv.taskmanagerapp.domain.dto.UserDto;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

import static com.andrewsmv.taskmanagerapp.testutils.Constants.EMAIL;

@UtilityClass
public class TestUserDto {

    public static UserDto getUserDto() {
        UserDto user = new UserDto();
        user.setId(1L);
        user.setEmail(EMAIL);
        user.setCreatedDate(LocalDate.of(2024, 9, 21));
        user.setLastModifiedDate(LocalDate.of(2024, 9, 21));
        return user;
    }
}
