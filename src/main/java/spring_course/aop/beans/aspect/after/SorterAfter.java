package spring_course.aop.beans.aspect.after;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SorterAfter {

    @Pointcut("execution(* spring_course.aop.beans.Sorter.*(..))")
    public void after(){

    }

    // This will execute after method for success or failure
    @After("after()")
    public void afterProcessing(JoinPoint point){

        System.out.println("Run after method " + point.getSignature().getName());

    }

}
