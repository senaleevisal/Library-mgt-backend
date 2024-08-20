package dev.senaleevisal.library.service;

import dev.senaleevisal.library.dao.Library;
import org.springframework.validation.annotation.Validated;

@Validated
public interface LibraryService {
    boolean deleteLibrary(int id);

    Library updateLibrary(int id, Library library);

    Library addLibrary(Library library);
}
