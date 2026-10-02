package edu.nerzon.backend_course.dto;

public record UserUpdateRequest(
        String username,
        Integer age
) {
}
