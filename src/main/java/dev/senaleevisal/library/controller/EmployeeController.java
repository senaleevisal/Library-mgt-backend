package dev.senaleevisal.library.controller;

import dev.senaleevisal.library.dao.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dev.senaleevisal.library.dto.ResponseBody.ResponseBody;
import dev.senaleevisal.library.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/api/library/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @PostMapping("/register")
    public ResponseBody registerEmployee(@Valid @RequestBody Employee employee) {
        ResponseBody response = new ResponseBody();
        if (employeeService.registerEmployee(employee)) {
            response.addResponse("state", "success");
            response.addResponse("message", "Employee registered successfully");
        } else {
            response.addResponse("state", "error");
            response.addResponse("message", "Employee not added");
        }
        return response;
    }

    @PostMapping("/login")
    public ResponseBody loginEmployee(@RequestBody String employeeEmail, @RequestBody String employeePassword) {
        ResponseBody response = new ResponseBody();
        int employeeId = employeeService.loginEmployee(employeeEmail, employeePassword);
        if (employeeId != -1) {
            response.addResponse("state", "success");
            response.addResponse("message", "Employee logged in successfully");
            response.addResponse("id", String.valueOf(employeeId));
        } else {
            response.addResponse("state", "error");
            response.addResponse("message", "Employee not found");
        }
        return response;
    }

}
