package dev.senaleevisal.library.dao;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Book {
    private int id;
    @NotNull(message = "Title is required")
    private String title;
    @NotNull(message = "Author is required")
    private String author;
    @NotNull(message = "ISBN is required")
    private String isbn;
    @NotNull(message = "Description is required")
    private String description;
    @NotNull(message = "Language is required")
    private String language;
}
