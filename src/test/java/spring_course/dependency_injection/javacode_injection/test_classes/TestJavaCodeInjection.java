package spring_course.dependency_injection.javacode_injection.test_classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_course.dependency_injection.javacode_injection.Config;
import spring_course.dependency_injection.javacode_injection.beans.Car;
import spring_course.dependency_injection.javacode_injection.beans.Pride;
import spring_course.dependency_injection.javacode_injection.beans.Samand;

public class TestJavaCodeInjection {

    AnnotationConfigApplicationContext context;

    @BeforeEach
    public void createNewContext(){
        context = new AnnotationConfigApplicationContext(Config.class);
    }

    @Test
    public void testConstructorInjection(){
        Car pride = context.getBean("pride", Car.class);

        Assertions.assertEquals(pride.getName(), "mmm");

        pride.drive();
    }

    @Test
    public void testSetterInjection(){
        Car samand = context.getBean("samand", Car.class);

        Assertions.assertEquals(samand.getName(), "mmm");

        samand.drive();
    }

    @Test
    public void testSingletonScope(){
        Samand samand = context.getBean("samand", Samand.class);

        samand.setName("aaa");

        Samand samand2 = context.getBean("samand", Samand.class);

        Assertions.assertEquals(samand2.getName(), "aaa");
    }

    @Test
    public void testPrototypeScope(){
        Pride pride = context.getBean("pride", Pride.class);

        pride.setName("aaa");

        Pride pride2 = context.getBean("pride", Pride.class);

        Assertions.assertEquals(pride2.getName(), "mmm");
    }

    @Test
    public void ReferenceInjection(){
        Car pride = context.getBean("pride", Car.class);

        Assertions.assertEquals(pride.getCompany().getCompanyName(), "companyName");
    }

    @Test
    public void testReferenceAutowiredInjection(){
        Car samand = context.getBean("samand", Car.class);

        Assertions.assertEquals(samand.getCompany().getCompanyName(), "companyName");
    }

    @Test
    public void testInitDestroyMethod(){
        Car pride = context.getBean("pride", Car.class);

        context.close();
    }

}
