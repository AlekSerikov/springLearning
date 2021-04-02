package com.example.demo.service;


import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository; //содержит дефортные методы

    @Override
//    @Transactional      большне не нужна, т.к. springboot сделает все сам
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
//    @Transactional
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
//    @Transactional
    public Employee getEmployee(int id) {
        Employee employee = null;
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()){
            employee = optionalEmployee.get();
        }
        return employee;
    }

    @Override
//    @Transactional
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployeesByName(String name) {
        return employeeRepository.findAllByName(name);
    }
}