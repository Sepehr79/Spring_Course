package spring_course.dependency_injection.annotation_injection.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@PropertySource("properties/application.properties")
public class Student {

    // default value
    @Value("${person.name}")
    private String name;

    @Value("${person.lastName}")
    private String lastName;

    @Value("20")
    private int age;

    @Autowired // field injection by autowired
    @Qualifier("chemistry") // injection when beans are same by id
    private ICourse course;

    public void learn(){
        System.out.println("In the learning method");
    }

    //@Autowired constructor injection by autowired
    public Student(String name, String lastName, int age, ICourse course) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.course = course;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ICourse getCourse() {
        return course;
    }

    //@Autowired setter injection by autowired
    public void setCourse(ICourse course) {
        this.course = course;
    }
}
