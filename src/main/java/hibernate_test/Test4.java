package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test4 {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration() //создаем один раз и переиспользуем
                .configure("hibernate.cfg.xml") //если файл имеет стандартное название, то можно не писать
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); // создаем при каждом подключении
            session.beginTransaction();
//            Employee em = session.get(Employee.class, 1);
//            em.setSalary(99999);// обновится также и в таблице
            session.createQuery("update Employee set salary=100000 where name = 'Dima'").executeUpdate(); //свой запрос

            session.getTransaction().commit();
            System.out.println("done!");
        } finally {
            factory.close();
        }
    }
}
