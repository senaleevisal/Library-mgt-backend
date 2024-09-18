package dev.senaleevisal.library.service.IMPL;

import dev.senaleevisal.library.dao.Employee;
import dev.senaleevisal.library.dto.EmployeeEntity;
import dev.senaleevisal.library.repository.EmployeeRepository;
import dev.senaleevisal.library.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modalMapper;

    @Autowired
    public EmployeeServiceIMPL(EmployeeRepository employeeRepository, ModelMapper modalMapper) {
        this.employeeRepository = employeeRepository;
        this.modalMapper = modalMapper;
    }

    @Override
    public boolean registerEmployee(Employee employee) {
        EmployeeEntity employeeEntity = modalMapper.map(employee, EmployeeEntity.class);
        return employeeRepository.save(employeeEntity) == employeeEntity;
    }

    @Override
    public int loginEmployee(String employeeEmail, String employeePassword) {
        if (employeeRepository.existsByEmail(employeeEmail) &&
                employeeRepository.findByEmail(employeeEmail).getPassword().equals(employeePassword)) {

            return employeeRepository.findByEmail(employeeEmail).getId();
        }
        return -1;
    }

}
