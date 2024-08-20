package dev.senaleevisal.library.dao;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Library {
    private int id;
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
    private String phoneNumber;

    @Email(message = "Email should be valid email")
    private String email;

    @NotNull(message = "Rating is mandatory")
    private int rating;
}