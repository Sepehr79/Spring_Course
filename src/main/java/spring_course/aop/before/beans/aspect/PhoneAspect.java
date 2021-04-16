package spring_course.aop.before.beans.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PhoneAspect {

    @Pointcut("execution(* spring_course.aop.before.beans.Phone.*(..))")
    public void phoneAllMethods(){

    }

    @Pointcut("execution(* spring_course.aop.before.beans.Phone.get*())")
    public void getter(){

    }

    @Pointcut("execution(void spring_course.aop.before.beans.Phone.set*(..))")
    public void setter(){

    }

    @Pointcut("phoneAllMethods() && !(getter() || setter())") // This will matches only call method
    public void anyExceptGettersAndSetters(){

    }

    @Before("anyExceptGettersAndSetters()")
    public void process(){
        System.out.println("Before call method");
    }

}
