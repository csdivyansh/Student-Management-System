package com.example.student_management_system.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.student_management_system.models.StudentModel;

public interface StudentRepository extends MongoRepository<StudentModel, String> {
    
}
