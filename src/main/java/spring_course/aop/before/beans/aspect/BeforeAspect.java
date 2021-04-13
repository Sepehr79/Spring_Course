package spring_course.aop.before.beans.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeAspect {

    /**
     * This method will be executed before invoke 'processLogic' method
     */
    @Before("execution(void spring_course.aop.before.beans.Logic.process*())")
    public void beforeMethod(){
        System.out.println("Run before void advice!");
    }

    @Before("execution(int process*())")
    public void beforeReturningMethod(){
        System.out.println("Run before returning advice!");
    }

}
