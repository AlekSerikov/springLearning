package aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Order(2)
public class LoggingAspect {

    @Pointcut("execution(public void aop.Lib.*(..))")
    public void addToAllMet(){}

    @Before("addToAllMet()")  //point kat
    public void beforeGetBookAdvise(JoinPoint joinPoint){
      MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        System.out.println(Arrays.toString(methodSignature.getParameterNames()));

        System.out.println("beforeGetBookAdvise: try get book");
    }

}
