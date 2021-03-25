package hibernate_many_to_many;

import hibernate_many_to_many.antity.Child;
import hibernate_many_to_many.antity.Section;
import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import org.hibernate.cfg.Configuration;

public class Test1 {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();


        Session session = null;

        try {
//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Football");
//
//            Child child1 = new Child("Alex", 10);
//            Child child2 = new Child("Dima", 8);
//            Child child3 = new Child("Nikita", 5);
//
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.beginTransaction();
//
//            session.save(section1);
//
//            session.getTransaction().commit();
//
//            System.out.println("Done!!!");

            //************************************************

            session = factory.getCurrentSession();

            Section section1 = new Section("Football");
            Section section2 = new Section("Chess");
            Section section3 = new Section("Math");

            Child child1 = new Child("Igor", 10);

            child1.addSectionToChild(section1);
            child1.addSectionToChild(section2);
            child1.addSectionToChild(section3);

            session.beginTransaction();

            session.save(child1);

            session.getTransaction().commit();

            System.out.println("Done!!!");


        } finally {

            factory.close();
        }


    }
}
