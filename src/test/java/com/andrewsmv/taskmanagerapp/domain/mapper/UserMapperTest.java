package com.andrewsmv.taskmanagerapp.domain.mapper;

import com.andrewsmv.taskmanagerapp.domain.dto.UserDto;
import com.andrewsmv.taskmanagerapp.domain.entity.User;
import com.andrewsmv.taskmanagerapp.testutils.TestUser;
import com.andrewsmv.taskmanagerapp.testutils.TestUserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserMapperTest {

    @InjectMocks
    private UserMapperImpl userMapper;

    @Test
    void toUserDto() {
        User user = TestUser.getUser();
        UserDto actual = userMapper.toUserDto(user);

        assertEquals(user.getId(), actual.getId());
        assertEquals(user.getEmail(), actual.getEmail());
        assertEquals(user.getCreatedDate(), actual.getCreatedDate());
        assertEquals(user.getLastModifiedDate(), actual.getLastModifiedDate());
    }

    @Test
    void toUser() {
        UserDto userDto = TestUserDto.getUserDto();

        User actual = userMapper.toUser(userDto);

        assertEquals(userDto.getEmail(), actual.getEmail());
    }
}