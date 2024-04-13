package com.springboot.project1.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<StudentResponseDTO> findAll() {
        return studentService.findAll();
    }

    @PostMapping("/students")
    public StudentResponseDTO saveStudent(@RequestBody StudentDTO dto) {
        var student = studentService.saveStudent(dto);
        return student;
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDTO getStudentById(@PathVariable("student-id") Integer id) {
        var student = studentService.getStudentById(id);
        return student;
    }

}
