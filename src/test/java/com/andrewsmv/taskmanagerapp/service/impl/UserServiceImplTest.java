package com.andrewsmv.taskmanagerapp.service.impl;

import com.andrewsmv.taskmanagerapp.domain.entity.User;
import com.andrewsmv.taskmanagerapp.repository.UserRepository;
import com.andrewsmv.taskmanagerapp.testutils.TestUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void create() {
        User expected = TestUser.getUser();
        when(userRepository.save(expected))
                .thenReturn(expected);

        User actual = userService.create(expected);

        assertEquals(expected, actual);
        verify(userRepository).save(expected);
    }
}
