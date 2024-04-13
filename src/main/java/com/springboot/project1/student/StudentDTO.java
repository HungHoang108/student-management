package com.springboot.project1.student;

import jakarta.validation.constraints.NotNull;

public record StudentDTO(
        @NotNull(message = "First name should not be empty")
        String firstName,
        @NotNull(message = "Last name should not be empty")
        String lastName,
        @NotNull(message = "Email should not be empty")
        String email,
        Integer schoolId
) {
}
