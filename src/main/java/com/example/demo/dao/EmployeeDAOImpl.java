package com.example.demo.dao;

import com.example.demo.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

//    @Autowired
//    private SessionFactory sessionFactory;

    @Autowired
    private EntityManager entityManager; //аналог session, создается автоматически

    @Override
    public List<Employee> getAllEmployees() {
//        Session session = entityManager.unwrap(Session.class); //entityManager - это обертка над session
//        List<Employee> allEmployees =  session.createQuery("from Employee", Employee.class).getResultList();
//        return allEmployees;

        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {//save or update
//        Session session = sessionFactory.getCurrentSession();
//        session.saveOrUpdate(employee);//if id !=0 update, or save

        Employee newEmployee = entityManager.merge(employee); //same session.saveOrUpdate(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {
//        return sessionFactory.getCurrentSession().get(Employee.class, id);
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");
//        query.setParameter("employeeId", id);
//        query.executeUpdate();
        //or
//        sessionFactory.getCurrentSession().delete(getEmployee(id));

        Query query = entityManager.createQuery("delete from Employee where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
