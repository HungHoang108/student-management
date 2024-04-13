package com.springboot.project1.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
    public SchoolDTO toSchoolDto(School school) {
        return new SchoolDTO(school.getName());
    }
}
