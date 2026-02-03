package com.example.student_management_system.services;

import com.example.student_management_system.DTO.StudentRequestDTO;
import com.example.student_management_system.DTO.StudentResponseDTO;
import com.example.student_management_system.exceptions.StudentNotFoundException;
import com.example.student_management_system.models.StudentModel;
import com.example.student_management_system.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentResponseDTO addStudent(StudentRequestDTO dto) {
        StudentModel student = new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel saved = repository.save(student);

        return new StudentResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }

    public List<StudentResponseDTO> getStudents() {
        return repository.findAll()
                .stream()
                .map(s -> new StudentResponseDTO(
                        s.getId(),
                        s.getName(),
                        s.getAge(),
                        s.getEmail()
                ))
                .toList();
    }

    public StudentResponseDTO updateStudent(String id, StudentRequestDTO dto) {
        StudentModel existing = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));

        existing.setName(dto.getName());
        existing.setAge(dto.getAge());
        existing.setEmail(dto.getEmail());

        StudentModel updated = repository.save(existing);

        return new StudentResponseDTO(
                updated.getId(),
                updated.getName(),
                updated.getAge(),
                updated.getEmail()
        );
    }

    public void deleteStudent(String id) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException("Student Not Found");
        }
        repository.deleteById(id);
    }
}
