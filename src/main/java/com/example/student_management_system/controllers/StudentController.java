package com.example.student_management_system.controllers;

import com.example.student_management_system.DTO.StudentRequestDTO;
import com.example.student_management_system.DTO.StudentResponseDTO;
import com.example.student_management_system.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public StudentResponseDTO addStudent(@Valid @RequestBody StudentRequestDTO dto) {
        return service.addStudent(dto);
    }

    @GetMapping
    public List<StudentResponseDTO> getStudents() {
        return service.getStudents();
    }

    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent(@PathVariable String id,
                                            @Valid @RequestBody StudentRequestDTO dto) {
        return service.updateStudent(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable String id) {
        service.deleteStudent(id);
        return "Deleted";
    }
}
