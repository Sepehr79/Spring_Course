package spring_course.aop.beans.aspect.afterthrowing;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionAfterThrowing {

    // Matches all methods in ExceptionGenerator
    @Pointcut("execution(* spring_course.aop.beans.ExceptionGenerator.*(..))")
    public void thrower(){

    }

    @AfterThrowing(value = "thrower()", throwing = "ex")
    public void processException(JoinPoint point, Throwable ex){
        System.out.println("Run after throwing method" + ex);
        System.out.println(point.getSignature());
    }

}