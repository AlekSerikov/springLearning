package hibernate_one_to_one;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration() //создаем один раз и переиспользуем
                .configure("hibernate.cfg.xml") //если файл имеет стандартное название, то можно не писать
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession(); // создаем при каждом подключении
//            Employee employee = new Employee("Misha", "Fedorov", "HR", 400);
//            Detail detail = new Detail("London", "12312455", "mnisha@mail.com");
//            detail.setEmployee(employee);
//            employee.setEmpDetail(detail);

            session.beginTransaction();

            Detail detail = session.get(Detail.class, 3);
            System.out.println(detail.getEmployee());
            detail.getEmployee().setEmpDetail(null);

            session.getTransaction().commit();
            System.out.println("Done");
        } finally {
            factory.close();
        }
    }

}
