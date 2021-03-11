package spring_course.dependency_injection.xml_injection.test_classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_course.dependency_injection.xml_injection.beans.Family;
import spring_course.dependency_injection.xml_injection.beans.Person;


public class TestXmlInjection {

    private ApplicationContext context;

    @BeforeEach
    public void createNewContext(){
        context = new ClassPathXmlApplicationContext("spring_course/dependency_injection/xml_config/applicationContext.xml");
    }

    @Test
    public void testXmlSetConstInjection(){
        Person conPerson = context.getBean("con_inj", Person.class);

        Assertions.assertEquals(conPerson.getAge(), 20);

        Person setPerson = context.getBean("set_inj", Person.class);

        Assertions.assertEquals(setPerson.getAge(), 20);
    }

    @Test
    public void testInitDestroyMethods(){

        // init method will be invoked
        Person person = context.getBean("init_destroy", Person.class);

        // destroy method will be invoked
        ((ConfigurableApplicationContext)context).close(); // some times you can invoke context.close();
    }

    @Test
    public void testInjectReferences(){
        Family family = context.getBean("family", Family.class);

        System.out.println(family.getFather().getName());
        System.out.println(family.getMother().getName());
    }

    @Test
    public void testSingletonBean(){
        Person person = context.getBean("con_inj", Person.class);

        person.setName("bbd");

        Person person2 = context.getBean("con_inj", Person.class);

        // name of bean is changed
        Assertions.assertEquals(person2.getName(), "bbd");
    }

    @Test
    public void testPrototypeBean(){
        Person person = context.getBean("pro_person", Person.class);

        person.setName("bbd");

        Person person2 = context.getBean("pro_person", Person.class);

        // name of bean is not changed
        Assertions.assertEquals(person2.getName(), "sepehr");
    }

    @Test
    public void testInjectionByPropertiesFile(){
        Person person = context.getBean("prop_person", Person.class);

        Assertions.assertEquals(person.getName(), "sepehr");
    }
}
