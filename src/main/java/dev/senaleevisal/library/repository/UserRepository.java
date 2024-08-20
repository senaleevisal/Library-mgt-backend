package dev.senaleevisal.library.repository;


import dev.senaleevisal.library.dto.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    boolean existsByEmail(String email);
    UserEntity findByEmail(String email);
}