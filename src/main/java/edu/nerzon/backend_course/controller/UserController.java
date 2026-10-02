package edu.nerzon.backend_course.controller;

import edu.nerzon.backend_course.dto.UserCreationRequest;
import edu.nerzon.backend_course.dto.UserUpdateRequest;
import edu.nerzon.backend_course.entity.User;
import edu.nerzon.backend_course.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserCreationRequest userCreationRequest) {
        return ResponseEntity.ok(userService.createUser(userCreationRequest));
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> update(@PathVariable Long userId, @RequestBody UserUpdateRequest userUpdateRequest) {
        return ResponseEntity.ok(userService.updateUser(userId, userUpdateRequest));
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.deleteUserById(userId);
    }
}
