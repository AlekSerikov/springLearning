package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test3 {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration() //создаем один раз и переиспользуем
                .configure("hibernate.cfg.xml") //если файл имеет стандартное название, то можно не писать
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); // создаем при каждом подключении
            session.beginTransaction();
            List<Employee> employees = session.createQuery("from Employee where salary>500").getResultList();

            employees.forEach(System.out::println);
            session.getTransaction().commit();

            System.out.println("done!");
        } finally {
            factory.close();
        }
    }
}
