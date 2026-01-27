package com.example.student_management_system.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class StudentModel {
    @Id
    private String id;
    private String name;
    private String email;
    private int age;
}
