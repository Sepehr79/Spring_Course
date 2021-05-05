package spring_course.aop.afterthrowing;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_course.aop.AspectConfig;
import spring_course.aop.beans.ExceptionGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AspectConfig.class})
public class AfterException {

    @Autowired
    private ExceptionGenerator generator;

    @Test
    public void testAfterThrowing(){
        try {
            generator.throwRuntimeException();

            Assert.fail();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

}
