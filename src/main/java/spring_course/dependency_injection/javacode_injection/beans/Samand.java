package spring_course.dependency_injection.javacode_injection.beans;

public class Samand extends Car {

    public Samand(String name, Company company, int year) {
        super(name, company, year);
    }

    public Samand() {
        super();
    }

    @Override
    public void drive() {
        System.out.println("Driving with samand!");
    }
}
