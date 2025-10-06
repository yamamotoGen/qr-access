package ru.aksh.qraccess.service;

import ru.aksh.qraccess.domain.User;
import ru.aksh.qraccess.model.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(String lastName, String firstName, String middleName);

    void updateUser(Long id, User user);

    List<UserResponse> findAll();

    UserResponse findById(Long id);

    void deleteById(Long id);
}