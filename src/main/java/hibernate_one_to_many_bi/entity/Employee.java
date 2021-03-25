package hibernate_one_to_many_bi.entity;

import hibernate_one_to_one.entity.Detail;

import javax.persistence.*;

@Entity
@Table(name = "employees") //таблица с которой сзязан бин
public class Employee {

    @Id  //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name") //если название совпадает, то можно опустить name
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "salary")
    private double salary;

    @ManyToOne(cascade = CascadeType.ALL) //чтобы не удалять всех работкников при удалении департамента и наоборот
    @JoinColumn(name = "department_id") //имя столбца в таблице, который foreign key
    private Department department;

    public Employee() {
    }

    public Employee(String name, String surname, double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
