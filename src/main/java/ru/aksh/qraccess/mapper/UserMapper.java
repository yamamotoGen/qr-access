package ru.aksh.qraccess.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import ru.aksh.qraccess.domain.User;
import ru.aksh.qraccess.model.response.UserResponse;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserResponse toUserResponse(User user);

    @Mapping(target = "id", ignore = true)
    void updateUserResponse(@MappingTarget User currentUser, User updateUserDetails);

    List<UserResponse> toUserResponseList(List<User> users);
}