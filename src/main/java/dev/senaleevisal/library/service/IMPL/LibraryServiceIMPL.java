package dev.senaleevisal.library.service.IMPL;

import dev.senaleevisal.library.dao.Library;
import dev.senaleevisal.library.dto.LibraryEntity;
import dev.senaleevisal.library.repository.LibraryRepository;
import dev.senaleevisal.library.service.LibraryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceIMPL implements LibraryService {

    private final LibraryRepository libraryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public LibraryServiceIMPL(LibraryRepository libraryRepository, ModelMapper modelMapper) {
        this.libraryRepository = libraryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Library addLibrary(Library library) {
        LibraryEntity libraryEntity = modelMapper.map(library, LibraryEntity.class);
        LibraryEntity savedEntity = libraryRepository.save(libraryEntity);
        return modelMapper.map(savedEntity, Library.class);
    }

    @Override
    public boolean deleteLibrary(int id) {
        if (libraryRepository.existsById(String.valueOf(id))) {
            libraryRepository.deleteById(String.valueOf(id));
            return true;
        }
        return false;
    }

    @Override
    public Library updateLibrary(int id, Library library) {
        if (libraryRepository.existsById(String.valueOf(id))) {
            LibraryEntity libraryEntity = modelMapper.map(library, LibraryEntity.class);
            libraryEntity.setId(id);
            LibraryEntity updatedEntity = libraryRepository.save(libraryEntity);
            return modelMapper.map(updatedEntity, Library.class);
        }
        return null;
    }
}