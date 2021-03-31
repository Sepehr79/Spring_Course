package spring_course.database.springwithhibernate.sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConfigurationHibernate {

    private ApplicationContext context;

    @Test
    public void testConfigurationTables(){
        context = new ClassPathXmlApplicationContext("spring_course/database/springwithhibernate/springOrm.xml");

        SessionFactory factory = context.getBean("sessionFactory", SessionFactory.class);

        Session session = factory.openSession();

        // This will auto create student table in database

        session.close();
    }

}
