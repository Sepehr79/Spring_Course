package spring_course.dependency_injection.annotation_injection.test_classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_course.dependency_injection.annotation_injection.beans.Student;

public class TestAnnotationInjection {

    private ApplicationContext context;

    @BeforeEach
    public void createNewContext(){
        context = new ClassPathXmlApplicationContext("spring_course/dependency_injection/annotation_config/annotationInjectionContext.xml");
    }

    @Test
    public void testAnnotationInjection(){
        Student student = context.getBean("student", Student.class);

        student.learn();
    }

    @Test
    public void testDefaultValue(){
        Student student = context.getBean("student", Student.class);

        Assertions.assertEquals(student.getName(), "sepehr");

        Assertions.assertEquals(student.getAge(), 20);
    }

    @Test
    public void testAutowiredInjection(){
        Student student = context.getBean("student", Student.class);

        student.getCourse().teachToStudent();
    }

    @Test
    public void testPrototypeScope(){
        Student student = context.getBean("student", Student.class);

        student.setName("ali");

        Student student2 = context.getBean("student", Student.class);

        Assertions.assertEquals(student2.getName(), "sepehr");
    }

}
