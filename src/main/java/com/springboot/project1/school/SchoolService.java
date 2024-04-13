package com.springboot.project1.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepository repository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository repository, SchoolMapper schoolMapper) {
        this.repository = repository;
        this.schoolMapper = schoolMapper;
    }

    public List<SchoolDTO> getAllStudents() {
        return repository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList());
    }

    public SchoolDTO createSchool(School school) {
        return schoolMapper.toSchoolDto(repository.save(school));
    }

    public SchoolDTO getSchoolById(Integer id) {
        var school = repository.findById(id);
        return school.map(schoolMapper::toSchoolDto).orElse(null);
    }
}
