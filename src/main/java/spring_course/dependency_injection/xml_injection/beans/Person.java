package spring_course.dependency_injection.xml_injection.beans;

// please see xml configuration at resources/spring_course/dependency_injection/xml_config
public class Person {

    private String name;
    private String lastName;
    private int age;

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Person() {
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

    public void initPerson(){
        System.out.println("In the init method");
    }

    public void destroyPerson(){
        System.out.println("In the destroy method");
    }
}
