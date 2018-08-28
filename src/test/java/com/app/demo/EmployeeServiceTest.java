package com.app.demo;

import com.app.demo.repository.EmployeeRepository;
import com.app.demo.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(EmployeeService.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @Test
    public void getEmployeeDetails(){
        given(employeeRepository.findById(1));
    }

}
