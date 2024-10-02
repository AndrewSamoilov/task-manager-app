package com.andrewsmv.taskmanagerapp.controller;

import com.andrewsmv.taskmanagerapp.domain.dto.UserDto;
import com.andrewsmv.taskmanagerapp.domain.mapper.UserMapper;
import com.andrewsmv.taskmanagerapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUser(@PathVariable Long id) {
        return userMapper.toUserDto(userService.get(id));
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @Valid @RequestBody UserDto userDto) {
        return userMapper.toUserDto(userService.update(id, userMapper.toUser(userDto)));
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<UserDto> getUsers(Pageable pageable) {
        return userService.getAll(pageable)
                .map(userMapper::toUserDto);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        return userMapper.toUserDto(userService.create(userMapper.toUser(userDto)));
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
