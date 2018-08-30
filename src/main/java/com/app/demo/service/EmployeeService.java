package com.app.demo.service;

import com.app.demo.dto.EmployeeDto;
import com.app.demo.model.Employee;
import com.app.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee();

        if(employeeDto.getEmpName() != null){
            employee.setEmpName(employeeDto.getEmpName());
        }
        if(employeeDto.getPassword() != null){
            employee.setPassword(employeeDto.getPassword());
        }
        if(employeeDto.getEmail() != null){
            employee.setEmail(employeeDto.getEmail());
        }

        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployee(Integer id) {
        return employeeRepository.findById(id);
    }

}
