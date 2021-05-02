package spring_course.aop.before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_course.aop.AspectConfig;
import spring_course.aop.beans.Person;
import spring_course.aop.beans.Sorter;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AspectConfig.class})
public class BeforeAdvice {

    @Autowired
    private Person person;

    @Autowired
    private Sorter sorter;

    @Test
    public void testBeforeAdvice(){

        person.setName("sepehr");
        // output:
        // Process before method with signature: void spring_course.aop.beans.Person.setName(String)
        // Arg: sepehr

        String name = person.getName();
        // output:
        // Process before method with signature: String spring_course.aop.beans.Person.getName()

        person.talk("salam");
        // output:
        // Process before talk method
        // Args: salam
        // salam

    }

    /*
     * For aop in this case you just need this dependency not any more:
     * <dependency>
     *       <groupId>org.aspectj</groupId>
     *       <artifactId>aspectjweaver</artifactId>
     *       <version>1.8.13</version>
     *   </dependency>
     *
     */

}
