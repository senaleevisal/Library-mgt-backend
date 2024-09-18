package dev.senaleevisal.library.dao;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    private int id;
    @NotBlank(message = "Name cannot be null")
    private String name;
    @NotBlank(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Password cannot be null")
    private String password;
    private String phone;

}
