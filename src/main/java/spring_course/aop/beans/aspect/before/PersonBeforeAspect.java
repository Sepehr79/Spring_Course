package spring_course.aop.beans.aspect.before;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PersonBeforeAspect {

    // Matches only setter methods
    @Pointcut("execution(void spring_course.aop.beans.Person.set*(..))")
    public void setter(){

    }

    // Matches only getter methods
    @Pointcut("execution(* spring_course.aop.beans.Person.get*())")
    public void getter(){

    }

    // Matches all methods
    @Pointcut("execution(* spring_course.aop.beans.Person.*(..))")
    public void allMethods(){

    }

    @Before("setter()")
    public void processBeforeSetter(JoinPoint joinPoint){
        System.out.println("Process before method with signature: " + (MethodSignature)joinPoint.getSignature());
        System.out.println("Arg: " + joinPoint.getArgs()[0]);
    }

    @Before("getter()")
    public void processBeforeGetter(JoinPoint joinPoint){
        System.out.println("Process before method with signature: " + (MethodSignature) joinPoint.getSignature());
    }

    // Matches all methods except getters and setters
    @Before("allMethods() && !(getter() || setter())")
    public void exceptGetterSetter(JoinPoint point){
        System.out.println("Process before talk method");
        System.out.println(("Args: " + (String) point.getArgs()[0]));
    }

}
