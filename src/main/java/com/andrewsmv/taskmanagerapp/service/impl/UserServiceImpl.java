package com.andrewsmv.taskmanagerapp.service.impl;

import com.andrewsmv.taskmanagerapp.common.Constants;
import com.andrewsmv.taskmanagerapp.common.exception.NotFoundException;
import com.andrewsmv.taskmanagerapp.domain.entity.User;
import com.andrewsmv.taskmanagerapp.repository.UserRepository;
import com.andrewsmv.taskmanagerapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public User create(User user) {
    log.debug("Creating user {}", user);
    return userRepository.save(user);
  }

  @Override
  public User get(Long id) {
    log.debug("Retrieving user {}", id);
    return userRepository.findById(id).orElseThrow(NotFoundException::new);
  }

  @Override
  public Page<User> getAll(Pageable pageable) {
    return userRepository.findAll(pageable);
  }

  @Override
  public User update(Long id, User user) {
    log.debug("Updating user {}", id);

    User userToUpdate = get(id);

    BeanUtils.copyProperties(user, userToUpdate, Constants.ID,
        Constants.CATEGORIES,
        Constants.CREATED_DATE,
        Constants.LAST_MODIFIED_DATE);

    return userRepository.save(userToUpdate);
  }

  @Override
  public void delete(Long id) {
    log.debug("Deleting user {}", id);
    userRepository.deleteById(id);
  }
}
