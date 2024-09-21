package com.andrewsmv.taskmanagerapp.service;

import com.andrewsmv.taskmanagerapp.domain.entity.User;

public interface UserService {
    User create(User user);

    User get(Long id);
}
