package spring_course.aop.beans;

import org.springframework.stereotype.Component;

@Component
public class ExceptionGenerator {

    public void throwRuntimeException(){
        throw new RuntimeException("This is custom exception");
    }

}
