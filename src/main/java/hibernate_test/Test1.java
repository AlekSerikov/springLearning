package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test1 {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration() //создаем один раз и переиспользуем
                .configure("hibernate.cfg.xml") //если файл имеет стандартное название, то можно не писать
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession(); // создаем при каждом подключении

            Employee employee = new Employee("Oleg2", "Petr2ov", "HR", 2003);

            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

            System.out.println(employee);
        } finally {
            factory.close();
        }
    }
}
