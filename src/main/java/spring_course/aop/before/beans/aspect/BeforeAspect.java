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
    @Before("execution(public void processLogic())")
    public void beforeMethod(){
        System.out.println("Run before advice!");
    }

}
