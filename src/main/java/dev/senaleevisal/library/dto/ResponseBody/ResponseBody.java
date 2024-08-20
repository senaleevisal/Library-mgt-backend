package dev.senaleevisal.library.dto.ResponseBody;

import dev.senaleevisal.library.dao.Book;
import dev.senaleevisal.library.dao.Library;
import dev.senaleevisal.library.dao.User;
import lombok.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class ResponseBody {
    private HashMap<String , List<Object>> response = new HashMap<>();

    public void addResponse(String status, String message){
        this.response.computeIfAbsent(status, k -> new ArrayList<>()).add(message);
    }

    public void addUser(String user, User user1) {
        this.response.computeIfAbsent(user, k -> new ArrayList<>()).add(user1);
    }

    public void addLibrary(String library, Library library_) {
        this.response.computeIfAbsent(library, k -> new ArrayList<>()).add(library_);
    }

    public void addBook(String book, Book addedBook) {
        this.response.computeIfAbsent(book, k -> new ArrayList<>()).add(addedBook);
    }
}