package ru.aksh.qraccess.service;

import ru.aksh.qraccess.domain.User;
import ru.aksh.qraccess.model.response.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponse createUser(String lastName, String firstName, String middleName);

    UserResponse updateUser(Integer id, User user);

    List<UserResponse> findAll();

    Optional<User> findById(Integer id);

    void deleteById(Integer id);
}