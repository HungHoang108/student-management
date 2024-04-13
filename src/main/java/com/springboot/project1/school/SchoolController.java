package com.springboot.project1.school;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }


    @GetMapping("/schools")
    public List<SchoolDTO> getAllSchools() {
        return schoolService.getAllStudents();
    }

    @PostMapping("/schools")
    public SchoolDTO insertSchool(@RequestBody School school) {
        return schoolService.createSchool(school);
    }

    @GetMapping("/schools/{school-id}")
    public SchoolDTO getSchoolById(@PathVariable("school-id") Integer id) {
        return schoolService.getSchoolById(id);
    }

}
