package spring_course.aop.before.beans;

import org.springframework.stereotype.Component;

@Component("logic")
public class Logic {

    public void processLogic(){
        System.out.println("processLogic method invoked!");
    }

}
