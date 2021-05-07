package spring_course.aop.beans.aspect.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundProcessorAdvice {

    // Matches all methods in the Processor
    @Pointcut("execution(* spring_course.aop.beans.Processor.*(..))")
    public void selectPoint(){

    }

    @Around("selectPoint()")
    public Object processAround(ProceedingJoinPoint pjp) throws Throwable{

        System.out.println("process before: " + pjp.getSignature());

        long begin = System.currentTimeMillis();

        Object result = pjp.proceed();

        long end = System.currentTimeMillis();

        System.out.println("process after: " + pjp.getSignature() + "\n with time: " + (end - begin));

        return result;
    }

}
