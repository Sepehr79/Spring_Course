package spring_course.aop.before.beans.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeAspect {

    @Pointcut("execution(void spring_course.aop.before.beans.Logic.process*(int, spring_course.aop.before.beans.Person, *, ..))")
    public void processAspect(){}

    @Before("processAspect()")
    public void beforeMethod(JoinPoint point){
        System.out.println("Run before void advice!");

        // Get method signature
        MethodSignature signature = (MethodSignature) point.getSignature();

        System.out.println(signature);

        // Get method arguments
        Object[] args = point.getArgs();

        for (Object arg: args)
            System.out.println(arg);

    }

    @Before("processAspect()")
    public void beforeMethod2(){
        System.out.println("Second run before void advice!");
    }

    @Before("execution(* spring_course.aop.before.beans.*.*(..))") // Matches any methods in arg package
    public void beforeReturningMethod(){
        System.out.println("Matches any method");
    }

}
