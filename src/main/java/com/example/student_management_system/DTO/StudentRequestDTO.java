package com.example.student_management_system.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(value = 5, message = "Age cannot be less than 5")
    @Max(value = 90, message = "Age cannot be greater than 90")
    private int age;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email can't be blank")
    private String email;
}
