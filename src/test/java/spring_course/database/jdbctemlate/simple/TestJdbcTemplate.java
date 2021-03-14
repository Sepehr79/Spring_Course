package spring_course.database.jdbctemlate.simple;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_course.database.jdbctemplate.beans.Emp;
import spring_course.database.jdbctemplate.beans.EmpDAO;
import spring_course.database.jdbctemplate.beans.Gender;

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

    @AfterEach
    public void deleteEmpDatabase(){
        dao.resetEmp();
    }


}
