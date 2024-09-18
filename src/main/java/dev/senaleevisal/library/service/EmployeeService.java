package dev.senaleevisal.library.service;

import dev.senaleevisal.library.dao.Employee;

public interface EmployeeService {
    boolean registerEmployee(Employee employee);
    int loginEmployee(String employeeEmail, String employeePassword);
}
