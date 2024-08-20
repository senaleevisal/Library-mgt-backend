package dev.senaleevisal.library.controller;

import dev.senaleevisal.library.dao.Library;
import dev.senaleevisal.library.dto.LibraryEntity;
import dev.senaleevisal.library.dto.ResponseBody.ResponseBody;
import dev.senaleevisal.library.service.LibraryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/library/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/add")
    public ResponseBody addLibrary(@Valid @RequestBody Library library) {
        Library addedLibrary = libraryService.addLibrary(library);
        ResponseBody response = new ResponseBody();
        response.addResponse("state", "success");
        response.addResponse("message", "Library added successfully");
        response.addLibrary("library", addedLibrary);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseBody deleteLibrary(@PathVariable int id) {
        ResponseBody response = new ResponseBody();
        if(libraryService.deleteLibrary(id)){
            response.addResponse("state", "success");
            response.addResponse("message", "Library deleted successfully");
        }
        else {
            response.addResponse("state", "error");
            response.addResponse("message", "Library not found");
        }
        return response;
    }

    @PutMapping("/update/{id}")
    public ResponseBody updateLibrary(@PathVariable int id, @Valid @RequestBody Library library) {
        Library updatedLibrary = libraryService.updateLibrary(id, library);
        ResponseBody response = new ResponseBody();
        if (updatedLibrary != null) {
            response.addResponse("state", "success");
            response.addResponse("message", "Library updated successfully");
            response.addLibrary("library", updatedLibrary);
        } else {
            response.addResponse("state", "error");
            response.addResponse("message", "Library not found");
        }
        return response;
    }
}