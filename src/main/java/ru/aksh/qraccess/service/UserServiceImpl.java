package ru.aksh.qraccess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aksh.qraccess.domain.User;
import ru.aksh.qraccess.exception.UserNotFoundException;
import ru.aksh.qraccess.model.response.UserResponse;
import ru.aksh.qraccess.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse createUser(String lastName, String firstName, String middleName) {
        User user = userRepository.save(new User(lastName, firstName, middleName));
        return new UserResponse(user);
    }

    @Override
    public UserResponse updateUser(Integer id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User id- " + id + " is not found"));
        return update(user, userDetails);
    }

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .toList();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    private UserResponse update(User user, User userDetails) {
        if (userDetails.getFirstName() != null) {
            user.setFirstName(userDetails.getFirstName());
        }

        if (userDetails.getLastName() != null) {
            user.setLastName(userDetails.getLastName());
        }

        if (userDetails.getMiddleName() != null) {
            user.setMiddleName(userDetails.getMiddleName());
        }

        return new UserResponse(userRepository.save(user));
    }
}
