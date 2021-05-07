package spring_course.aop.around;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_course.aop.AspectConfig;
import spring_course.aop.beans.Processor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AspectConfig.class})
public class AroundProcessorTest {


    @Autowired
    private Processor processor;

    @Test
    public void testWithNoReturning(){

        processor.process();

    }

    @Test
    public void testWithReturning(){

        processor.returningProcess(5);

    }

}
