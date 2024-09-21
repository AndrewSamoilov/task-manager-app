package com.andrewsmv.taskmanagerapp.repository;

import com.andrewsmv.taskmanagerapp.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
