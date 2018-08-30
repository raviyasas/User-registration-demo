package com.app.demo.controller;

import com.app.demo.dto.EmployeeDto;
import com.app.demo.dto.ResponseDto;
import com.app.demo.model.Employee;
import com.app.demo.repository.EmployeeRepository;
import com.app.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/register")
    public HttpEntity<ResponseDto> saveEmployee(@RequestBody EmployeeDto employeeDto){

        ResponseDto responseDto = new ResponseDto();

        if(employeeRepository.findByName(employeeDto.getEmpName()) != null){
            responseDto.setMessage("User already exists");
            responseDto.setStatus(false);
            return new ResponseEntity<>(responseDto, HttpStatus.CONFLICT);

        }else{
            employeeService.addEmployee(employeeDto);
            responseDto.setMessage("User has been created");
            responseDto.setStatus(true);
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        }
    }

    @GetMapping("/getAll")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/getEmployee/{id}")
    public Optional<Employee> getEmployee(@PathVariable Integer id){
        return employeeService.getEmployee(id);
    }

}
