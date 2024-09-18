package dev.senaleevisal.library.repository;

import dev.senaleevisal.library.dto.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {
    boolean existsByEmail(String email);
    EmployeeEntity findByEmail(String email);
}
