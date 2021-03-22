package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Lib {

    public void getBook(String personName, Book book) {
        System.out.println("get book");
        System.out.println("-----------------------");
    }

    public void putBook() {
        System.out.println("Put book");
        System.out.println("-----------------------");
    }

}
