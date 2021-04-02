package com.example.demo.dao;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository можно не писать т.к. он подразумевается
public interface EmployeeRepository extends JpaRepository<Employee, Integer> { // <Employee - тип сущности с которим будет работать репозиторий
                                                                               // Integer -  тип поля, который PK в Employee >


}
