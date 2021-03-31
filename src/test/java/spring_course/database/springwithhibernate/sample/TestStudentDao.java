package spring_course.database.springwithhibernate.sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;
import spring_course.database.springwithhibernate.dao.StudentDao;
import spring_course.database.springwithhibernate.entity.Student;

import java.util.List;

public class TestStudentDao {

    private static StudentDao studentDao;

    @BeforeAll
    static void createDao(){
        studentDao =
                new ClassPathXmlApplicationContext("spring_course/database/springwithhibernate/springOrm.xml").
        getBean("studentDao", StudentDao.class);
    }

    @AfterEach
    public void resetDataBase(){
        studentDao.resetDataBase();
    }

    @Test
    public void saveStudent(){

        Student student = new Student("sepehr", "mollaei", 20);

        // save at database
        studentDao.addStudent(student);

        List<Student> insertedStudents = studentDao.getStudentsByQuery("from Student where name = 'sepehr'");

        Assertions.assertEquals(insertedStudents.size(), 1);
    }

}
