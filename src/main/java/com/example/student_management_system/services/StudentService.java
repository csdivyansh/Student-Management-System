package com.example.student_management_system.services;

import org.springframework.stereotype.Service;
import com.example.student_management_system.models.StudentModel;
import com.example.student_management_system.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    public StudentModel addStudent(StudentModel student) {
        return repository.save(student);
    }
    public List<StudentModel> getStudents() {
        return repository.findAll();
    }
    public StudentModel updateStudent(String id, StudentModel student) {
        StudentModel existing = repository.findById(id).orElseThrow();
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setAge(student.getAge());
        return repository.save(existing);
    }

    public void deleteStudent(String id) {
        repository.deleteById(id);
    }
}
