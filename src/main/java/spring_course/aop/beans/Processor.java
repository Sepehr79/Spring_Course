package spring_course.aop.beans;

import org.springframework.stereotype.Component;

@Component
public class Processor {

    public Object returningProcess(int num){

        System.out.println("Processing some date with return object");

        return num;
    }

    public void process(){
        System.out.println("Processing some date without return object");
    }

}
