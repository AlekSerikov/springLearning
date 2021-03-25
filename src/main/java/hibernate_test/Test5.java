package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test5 {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration() //создаем один раз и переиспользуем
                .configure("hibernate.cfg.xml") //если файл имеет стандартное название, то можно не писать
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); // создаем при каждом подключении
            session.beginTransaction();
//            Employee em = session.get(Employee.class, 1);
//            session.delete(em);

            session.createQuery("delete Employee where name = 'Oleg2'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("done!");
        } finally {
            factory.close();
        }
    }
}
