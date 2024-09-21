package com.andrewsmv.taskmanagerapp.testutils;

import com.andrewsmv.taskmanagerapp.domain.entity.User;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

import static com.andrewsmv.taskmanagerapp.testutils.Constants.EMAIL;

@UtilityClass
public class TestUser {

    public static User getUser() {
        User user = new User();
        user.setId(1L);
        user.setEmail(EMAIL);
        user.setCreatedDate(LocalDate.of(2024, 9, 21));
        user.setLastModifiedDate(LocalDate.of(2024, 9, 21));
        return user;
    }
}
