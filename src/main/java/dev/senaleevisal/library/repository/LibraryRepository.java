package dev.senaleevisal.library.repository;

import dev.senaleevisal.library.dto.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<LibraryEntity, String> {
}
