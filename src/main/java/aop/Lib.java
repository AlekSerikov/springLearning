package aop;

import org.springframework.stereotype.Component;

@Component
public class Lib {
    public void getBook(){
        System.out.println("get book");
    }

}
