package com.andrewsmv.taskmanagerapp.service;

import com.andrewsmv.taskmanagerapp.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {
    User create(User user);

    User get(Long id);

    Page<User> getAll(Pageable pageable);

    User update(Long id, User user);
}
