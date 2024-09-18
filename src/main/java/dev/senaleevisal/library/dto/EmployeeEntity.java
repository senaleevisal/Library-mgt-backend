package dev.senaleevisal.library.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class EmployeeEntity {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String phone;


}
