package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner2 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Lib lib = context.getBean("lib", Lib.class);

        lib.getBook();



    }

}
