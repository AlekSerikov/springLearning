package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class NewAspect {

    @Before("aop.aspects.LoggingAspect.addToAllMet()")
    public void adviceFromNewAspect(){
        System.out.println("From new Aspect");


    }

}
