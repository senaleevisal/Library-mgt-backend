package dev.senaleevisal.library.repository;

import dev.senaleevisal.library.dto.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    BookEntity findByTitle(String title);

    BookEntity findByIsbn(String isbn);
}
