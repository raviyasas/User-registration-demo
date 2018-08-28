package com.app.demo;

import com.app.demo.model.Employee;
import com.app.demo.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void getEmployee(){
     Optional<Employee> employee = employeeRepository.findById(1);
        Assertions.assertThat(employee.get().getEmpName()).isEqualToIgnoringCase("ashan");
    }

    @Test
    public void getEmployeeByCreating(){
        Employee employee = new Employee();
        employee.setEmpName("John");
        employee.setDepartment(null);
        employee.setEmail("john@live.com");
        employee.setPassword("9999");

        Employee addEmployee = entityManager.persistAndFlush(employee);
        Employee newEmployee = employeeRepository.findByName("John");

        Assertions.assertThat(addEmployee).isEqualTo(newEmployee);
    }
}
