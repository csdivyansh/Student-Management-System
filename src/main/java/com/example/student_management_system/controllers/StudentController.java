package com.example.student_management_system.controllers;

import com.example.student_management_system.models.StudentModel;
import com.example.student_management_system.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService studentService) {
        this.service = studentService;
    }

    @PostMapping("/add")
    public StudentModel addStudent(@RequestBody StudentModel student) {
        return service.addStudent(student);
    }

    @GetMapping("/students")
    public List<StudentModel> getStudents() {
        return service.getStudents();
    }

    @PutMapping("/update/{id}")
    public StudentModel updateStudent(@PathVariable String id, @RequestBody StudentModel student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        service.deleteStudent(id);
        return "Deleted";
    }

}
