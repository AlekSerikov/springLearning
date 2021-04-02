package com.example.demo.controllers;


import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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

        employeeService.deleteEmployee(id);
        return "Employee with id " + id + " was deleted";
    }

    @GetMapping("/employee/name/{name}")
    public List<Employee> showAllEmployeesByName(@PathVariable String name){
        return employeeService.getAllEmployeesByName(name);
    }

}
