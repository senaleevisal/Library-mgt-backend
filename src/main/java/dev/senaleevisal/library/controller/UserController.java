package dev.senaleevisal.library.controller;

import dev.senaleevisal.library.dao.User;
import dev.senaleevisal.library.dto.ResponseBody.ResponseBody;
import dev.senaleevisal.library.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/library/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseBody RegisterUser(@Valid @RequestBody User user){
        ResponseBody response = new ResponseBody();
        if (userService.RegisterUser(user)){
            response.addResponse("state", "success");
            response.addResponse("message", "User registered successfully");
        }else {
            response.addResponse("state", "error");
            response.addResponse("message", "User not added");
        }
        return response;
    }

    @PostMapping("/login")
    public ResponseBody loginUser(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");
        ResponseBody response = new ResponseBody();
        int userId = userService.loginUser(email, password);
        if (userId != -1) {
            response.addResponse("state", "success");
            response.addResponse("message", "User logged in successfully");
            response.addResponse("id", String.valueOf(userId));
        } else {
            response.addResponse("state", "error");
            response.addResponse("message", "User not found");
        }
        return response;
    }

    @GetMapping("/getbyid/{id}")
    public ResponseBody getUser(@PathVariable int id){
        ResponseBody response = new ResponseBody();
        User user = userService.getUser(id);
        if (user != null){
            response.addResponse("state", "success");
            response.addUser("user", user);
        }else {
            response.addResponse("state", "error");
            response.addResponse("error", "User not found");
        }
        return response;
    }


}