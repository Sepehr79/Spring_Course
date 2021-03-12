package spring_course.dependency_injection.javacode_injection.beans;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class Car {

    private String name;

    @Autowired
    private Company company;

    private int year;

    public Car(String name, Company company, int year) {
        this.name = name;
        this.company = company;
        this.year = year;
    }

    public Car() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public abstract void drive();
}
