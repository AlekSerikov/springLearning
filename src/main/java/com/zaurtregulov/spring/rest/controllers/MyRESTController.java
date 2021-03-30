package com.zaurtregulov.spring.rest.controllers;

import com.zaurtregulov.spring.rest.entity.Employee;
import com.zaurtregulov.spring.rest.exception_hendling.EmployeeIncorrectData;
import com.zaurtregulov.spring.rest.exception_hendling.NoSuchEmployeeException;
import com.zaurtregulov.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees(); //спринг сам посредством jackson сконвертирует список в json и поместит в тело ответа
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in database");
        }
        return employee;
    }

    @PostMapping("/employees")//update employee
    public Employee addNewEmployee(@RequestBody Employee employee) { //get object from body post request(convert from json(jackson))
        //here is no id in employee
        employeeService.saveEmployee(employee);//employee saved and updated
        return employee;//return employee with id
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        if (employeeService.getEmployee(id) == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in database");
        }
        employeeService.deleteEmployee(id);
        return "Employee with id " + id + " was deleted";
    }

}
