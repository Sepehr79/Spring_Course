package spring_course.aop.beans.aspect.afterreturning;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SorterAfterReturningAspect {

    @Pointcut("execution(int[] spring_course.aop.beans.Sorter.bubbleSort(int[]))")
    public void afterReturn(){

    }

    // Run after the method (success execution)
    @AfterReturning(value = "afterReturn()", returning = "result")
    public void processAfterReturn(JoinPoint point, int[] result){


        System.out.println("Run after returning result from sorter");
        System.out.println("Method: " + point.getSignature());

        // modify returning object
        result[0] = 1;

    }

}
