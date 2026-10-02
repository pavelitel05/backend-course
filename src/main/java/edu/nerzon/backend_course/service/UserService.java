package edu.nerzon.backend_course.service;

import edu.nerzon.backend_course.dto.UserCreationRequest;
import edu.nerzon.backend_course.dto.UserUpdateRequest;
import edu.nerzon.backend_course.entity.User;
import edu.nerzon.backend_course.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        if (request.age() == null || request.username() == null) {
            throw new IllegalArgumentException();
        }

        User user = new User();
        user.setRegisteredAt(LocalDateTime.now());
        user.setUsername(request.username());
        user.setAge(request.age());

        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, UserUpdateRequest request) {
        if (request.age() == null || request.username() == null) {
            throw new IllegalArgumentException();
        }

        User user = userRepository.findById(id).orElse(null);
        if (user == null) return null;

        user.setAge(request.age());
        user.setUsername(request.username());

        return userRepository.save(user);
    }
}
