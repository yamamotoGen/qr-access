package ru.aksh.qraccess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aksh.qraccess.domain.User;
import ru.aksh.qraccess.exception.UserNotFoundException;
import ru.aksh.qraccess.mapper.UserMapper;
import ru.aksh.qraccess.model.response.UserResponse;
import ru.aksh.qraccess.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponse createUser(String lastName, String firstName, String middleName) {
        User user = userRepository.save(new User(lastName, firstName, middleName));
        return userMapper.toUserResponse(user);
    }

    @Override
    public void updateUser(Long id, User updateUserDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User id- " + id + " is not found"));
        userMapper.updateUserResponse(user, updateUserDetails);
        userRepository.save(user);
    }

    @Override
    public List<UserResponse> findAll() {
        List<User> users = userRepository.findAll();
        return userMapper.toUserResponseList(users);
    }

    @Override
    public UserResponse findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User id " + id + " is not found"));
        return userMapper.toUserResponse(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
