package spring_course.aop.before.beans;

import org.springframework.stereotype.Component;

@Component("logic")
public class Logic {

    public void processLogic(){
        System.out.println("processLogic method invoked!");
    }

    public void processSignup(){
        System.out.println("processSignup method invoked!");
    }

    public int processWithReturn(){
        System.out.println("processWithReturn invoked!");
        return 0;
    }

}
