package spring_course.database.jdbctemlate.simple;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_course.database.jdbctemplate.beans.Emp;
import spring_course.database.jdbctemplate.beans.EmpDAO;
import spring_course.database.jdbctemplate.beans.Gender;

import java.util.List;

public class TestJdbcTemplate {

    private EmpDAO dao;

    @BeforeEach
    public void createContext(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_course/database/jdbctemplate/dataBaseContext.xml");
        dao = context.getBean("empDao", EmpDAO.class);
    }

    @Test
    public void testInsertEmp(){
        Emp emp = new Emp("sepehr", "mollaei", 20, Gender.MALE, 4456);

        dao.saveEmp(emp);
    }

    @Test
    public void testInsertEmps(){
        dao.saveEmp(new Emp("sepehr", "mollaei", 20, Gender.MALE, 123));
        dao.saveEmp(new Emp("aaa", "4444", 20, Gender.MALE, 124));
        dao.saveEmp(new Emp("bbb", "5555", 20, Gender.MALE, 125));
        dao.saveEmp(new Emp("ccc", "6666", 20, Gender.MALE, 126));

        List<Emp> empList = dao.getEmps();

        Assertions.assertEquals(empList.size(), 4);
    }

    @Test
    public void testGetEmp(){
        dao.saveEmp(new Emp("sepehr", "mollaei", 20, Gender.MALE, 123));
        dao.saveEmp(new Emp("aaa", "4444", 20, Gender.MALE, 124));

        Emp emp = dao.getEmp(123);

        Assertions.assertEquals(emp.getName(), "sepehr");
    }

    @Test
    public void testGetNullEmp(){
        dao.saveEmp(new Emp("sepehr", "mollaei", 20, Gender.MALE, 123));

        Emp emp = dao.getEmp(130);

        Assertions.assertNull(emp);
    }

    @Test
    public void testUpdateEmp(){
        dao.saveEmp(new Emp("sepehr", "mollaei", 20, Gender.MALE, 123));

        Emp emp = new Emp("sepehr2", "mollaei", 21, Gender.MALE, 123);

        dao.updateEmp(emp);

        Emp editedEmp = dao.getEmp(123);

        Assertions.assertEquals(editedEmp.getName(), "sepehr2");
    }

    @Test
    public void testDeleteEmp(){
        dao.saveEmp(new Emp("sepehr", "mollaei", 20, Gender.MALE, 123));

        dao.deleteEmp(123);

        Emp deletedEmp = dao.getEmp(123);

        Assertions.assertNull(deletedEmp);
    }

    @AfterEach
    public void deleteEmpDatabase(){
        dao.resetEmp();
    }

}
