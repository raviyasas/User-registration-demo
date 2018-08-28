package com.app.demo;

import com.app.demo.model.Employee;
import com.app.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class DemoApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Employee employee = new Employee();
        employee.setEmpName("Ashan");
        employee.setEmail("ashan@live.com");
        employee.setPassword("1234");
        employeeRepository.save(employee);

        Employee employee2 = new Employee();
        employee2.setEmpName("Dilan");
        employee2.setEmail("dil@live.com");
        employee2.setPassword("5555");
        employeeRepository.save(employee2);

    }
}
