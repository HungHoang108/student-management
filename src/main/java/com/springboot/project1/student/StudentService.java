package com.springboot.project1.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDTO saveStudent(StudentDTO dto) {
        var student = studentMapper.toStudent(dto);
        var studentResponse = studentMapper.toStudentResponseDTO(repository.save(student));
        return studentResponse;
    }

    public List<StudentResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(studentMapper::toStudentResponseDTO)
                .collect(Collectors.toList());
    }

    public StudentResponseDTO getStudentById(Integer id) {
        var student = repository.findById(id);
        return student.map(studentMapper::toStudentResponseDTO).orElse(null);
    }
}
