package com.andrewsmv.taskmanagerapp.controller;

import com.andrewsmv.taskmanagerapp.domain.dto.UserDto;
import com.andrewsmv.taskmanagerapp.domain.mapper.UserMapper;
import com.andrewsmv.taskmanagerapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    @PostMapping
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        return userMapper.toUserDto(userService.createUser(userMapper.toUser(userDto)));
    }
}
