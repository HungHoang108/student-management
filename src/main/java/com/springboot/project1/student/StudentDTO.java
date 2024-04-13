package com.springboot.project1.student;

public record StudentDTO(
        String firstName,
        String lastName,
        String email,
        Integer schoolId
) {

}
