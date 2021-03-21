package org.example.spring;

import org.example.spring.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);


        Dog dog = context.getBean("dogBean", Dog.class);
        Cat cat = context.getBean("catBean", Cat.class);

        System.out.println(cat.getName());


    }
}
