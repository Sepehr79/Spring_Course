package spring_course.dependency_injection.annotation_injection.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("math")
public class Math implements ICourse {

    @Value("math")
    private String name;

    @Value("22")
    private int id;

    public Math(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Math() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void teachToStudent() {
        System.out.println("Learning math");
    }
}
