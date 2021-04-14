package spring_course.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_course.aop.before.AspectConfig;
import spring_course.aop.before.beans.Logic;
import spring_course.aop.before.beans.Person;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AspectConfig.class})
public class Before {

    @Autowired
    private Logic logic;

    @Test
    public void testBeforeAdvice(){
        logic.processLogic(5, new Person("sepehr", "mollaei"), false, "fewf", 456);
        // output:
        // Run Before advice!
        // Matches any method
        // processLogic invoked!

        logic.processWithReturn();
        // output:
        // Matches any method
        // processWithReturn invoked!
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
