package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test2 {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration() //создаем один раз и переиспользуем
                .configure("hibernate.cfg.xml") //если файл имеет стандартное название, то можно не писать
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); // создаем при каждом подключении

            Employee emp = new Employee("Dima", "Pavlov", "HR", 254);

            session.beginTransaction();
            session.save(emp);
//            session.getTransaction().commit();

            int myId = emp.getId();

            //get by id from db
//            session = factory.getCurrentSession();
//            session.beginTransaction();
            Employee employee = session.get(Employee.class, myId);
            session.getTransaction().commit();

            System.out.println(employee);
        } finally {
            factory.close();
        }
    }
}
