package com.andrewsmv.taskmanagerapp.domain.mapper;

import com.andrewsmv.taskmanagerapp.domain.dto.UserDto;
import com.andrewsmv.taskmanagerapp.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    UserDto toUserDto(User user);

    User toUser(UserDto userDto);
}
