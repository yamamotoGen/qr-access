package ru.aksh.qraccess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aksh.qraccess.domain.User;
import ru.aksh.qraccess.exception.UserNotFoundException;
import ru.aksh.qraccess.model.response.UserResponse;
import ru.aksh.qraccess.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping()
    public UserResponse createUser(String firstName, String lastName, String middleName) {
        return userService.createUser(firstName, lastName, middleName);
    }

    @GetMapping
    public List<UserResponse> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Integer id) {
        User user = userService.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User id " + id + " is not found"));
        return new UserResponse(user);
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Integer id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }
}
