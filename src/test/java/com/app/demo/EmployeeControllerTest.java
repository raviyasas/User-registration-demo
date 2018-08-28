package com.app.demo;

import com.app.demo.controller.EmployeeController;
import com.app.demo.model.Employee;
import com.app.demo.repository.EmployeeRepository;
import com.app.demo.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    EmployeeRepository employeeRepository;

    @MockBean
    EmployeeService employeeService;

    @Test
    public void getOneEmployee() throws Exception{

        Employee employee = new Employee();
        employee.setEmpName("Ashan");
        employee.setPassword("1234");
        employee.setEmail("ashan@live.com");
        employee.setDepartment(null);

        given(employeeService.getEmployee(1)).willReturn(java.util.Optional.ofNullable(employee));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/getEmployee/1"))
                .andExpect(jsonPath("empName").value("Ashan"))
                .andExpect(jsonPath("password").value("1234"))
                .andExpect(jsonPath("email").value("ashan@live.com"))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllEmployee() throws Exception{

        given(employeeService.getAllEmployees()).willReturn(new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/getAll"))
                .andExpect(status().isOk());
    }

}
