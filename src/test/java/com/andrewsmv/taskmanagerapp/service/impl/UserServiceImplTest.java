package com.andrewsmv.taskmanagerapp.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.andrewsmv.taskmanagerapp.common.exception.NotFoundException;
import com.andrewsmv.taskmanagerapp.domain.entity.User;
import com.andrewsmv.taskmanagerapp.repository.UserRepository;
import com.andrewsmv.taskmanagerapp.testutils.TestUser;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void create_worksCorrectly() {
        User expected = TestUser.getUser();
        when(userRepository.save(expected))
                .thenReturn(expected);

        User actual = userService.create(expected);

        assertEquals(expected, actual);
        verify(userRepository).save(expected);
    }

    @Test
    void get_worksCorrectly() {
        User expected = TestUser.getUser();

        when(userRepository.findById(1L))
            .thenReturn(Optional.of(expected));

        User actual = userService.get(1L);

        assertEquals(expected, actual);

        verify(userRepository).findById(1L);
    }


    @Test
    void get_whenUserNotFound_throwsException() {

        when(userRepository.findById(1L))
            .thenReturn(Optional.empty());

        assertThrowsExactly(NotFoundException.class, () -> userService.get(1L));

        verify(userRepository).findById(1L);
    }

    @Test
    void getAll_worksCorrectly() {
        Pageable pageable = PageRequest.of(0, 1);
        List<User> userList = List.of(TestUser.getUser());
        Page<User> users = new PageImpl<>(userList, pageable, userList.size());

        when(userRepository.findAll(pageable))
            .thenReturn(users);

        Page<User> actual = userService.getAll(pageable);

        assertEquals(users, actual);

        verify(userRepository).findAll(pageable);
    }

    @Test
    void update_worksCorrectly() {
        User income = TestUser.getUser();
        income.setEmail("update@email.com");

        User toUpdate = TestUser.getUser();
        toUpdate.setEmail("update@email.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(toUpdate));
        when(userRepository.save(toUpdate)).thenReturn(toUpdate);

        User actual = userService.update(1L, income);

        assertEquals(toUpdate, actual);

        verify(userRepository).findById(1L);
        verify(userRepository).save(toUpdate);
    }

    @Test
    void delete_worksCorrectly() {
        userService.delete(1L);
        verify(userRepository).deleteById(1L);
    }
}
