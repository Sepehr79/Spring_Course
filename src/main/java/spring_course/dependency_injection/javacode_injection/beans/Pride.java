package spring_course.dependency_injection.javacode_injection.beans;

public class Pride extends Car{

    public Pride(String name, Company company, int year) {
        super(name, company, year);
    }

    public Pride(){
        super();
    }

    @Override
    public void drive() {
        System.out.println("Driving with pride!");
    }

    public void init(){
        System.out.println("Pride init method");
    }

    public void destroy(){
        System.out.println("Pride destroy method");
    }
}
