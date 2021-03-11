package spring_course.dependency_injection.xml_injection.beans;

// please see xml configuration at resources/spring_course/dependency_injection/xml_config
public class Family {

    private Person father;
    private Person mother;

    public Family(Person father, Person mother) {
        this.father = father;
        this.mother = mother;
    }

    public Family() {
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }
}
