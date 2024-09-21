package com.andrewsmv.taskmanagerapp.service.impl;

import com.andrewsmv.taskmanagerapp.domain.entity.User;
import com.andrewsmv.taskmanagerapp.repository.UserRepository;
import com.andrewsmv.taskmanagerapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
