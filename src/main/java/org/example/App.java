package org.example;

import org.example.configuration.MyConfig;
import org.example.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication", Communication.class);

        List<Employee> employees = communication.getAllEmployees();
        System.out.println(employees);

        Employee empById = communication.getEmployee(1);
        System.out.println(empById);

//        Employee emp = new Employee("Sveta", "Sjk", 600, "HR");
//        communication.saveEmployee(emp);


//        Employee emp = new Employee("Sveta", "Sjk", 1600, "HR");
//        emp.setId(8);
//        communication.saveEmployee(emp);

        communication.deleteEmployee(8);


    }
}
