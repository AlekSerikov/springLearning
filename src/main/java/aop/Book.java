package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {

    @Value("Town of sin")
    private String name;

    @Value("King")
    private String author;

    @Value("2000")
    private int tearsOfPublication;


    public Book() {
    }

    public Book(String name, String author, int tearsOfPublication) {
        this.name = name;
        this.author = author;
        this.tearsOfPublication = tearsOfPublication;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTearsOfPublication() {
        return tearsOfPublication;
    }

    public void setTearsOfPublication(int tearsOfPublication) {
        this.tearsOfPublication = tearsOfPublication;
    }
}
