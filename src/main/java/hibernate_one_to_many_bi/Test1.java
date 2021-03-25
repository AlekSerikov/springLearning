package hibernate_one_to_many_bi;


import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration() //создаем один раз и переиспользуем
                .configure("hibernate.cfg.xml") //если файл имеет стандартное название, то можно не писать
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        try {
//            Session session = factory.getCurrentSession(); // создаем при каждом подключении
//            session.beginTransaction();
//
//            Department department = new Department("Sales", 800, 1500);
//            Employee em1 = new Employee("Alex", "Serikov", 800);
//            Employee em2 = new Employee("Elena", "Orlova", 1000);
//            Employee em3 = new Employee("Oleg", "Shalun", 1200);
//            department.addEmployeeToDepartment(em1);
//            department.addEmployeeToDepartment(em2);
//            department.addEmployeeToDepartment(em3);
//
//            session.save(department);
//
//            session.getTransaction().commit();
//            System.out.println("Done");

            //get employees from dep///////////////////////////////////////////////////////

            Session session = factory.getCurrentSession(); // создаем при каждом подключении
            session.beginTransaction();

            Department department = session.get(Department.class, 3);

            System.out.println(department.getEmps());

            session.getTransaction().commit();
            System.out.println("Done");

            //get dep from employee////////////////////////////////////

//            Session session = factory.getCurrentSession(); // создаем при каждом подключении
//            session.beginTransaction();
//
//            Employee employee = session.get(Employee.class, 1);
//
//            System.out.println(employee.getDepartment());
//
//            session.getTransaction().commit();
//            System.out.println("Done");

            //delete employee///////////////////////////////////////

//            Session session = factory.getCurrentSession(); // создаем при каждом подключении
//            session.beginTransaction();
//
//            Employee employee = session.get(Employee.class, 1);
//
//            session.delete(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
