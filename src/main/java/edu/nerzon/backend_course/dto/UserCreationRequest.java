package edu.nerzon.backend_course.dto;

public record UserCreationRequest(
        String username,
        Integer age
) {
}
