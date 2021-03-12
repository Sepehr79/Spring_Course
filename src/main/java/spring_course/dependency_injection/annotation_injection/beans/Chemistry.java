package spring_course.dependency_injection.annotation_injection.beans;

import org.springframework.stereotype.Component;

@Component("chemistry")
public class Chemistry implements ICourse {

    @Override
    public void teachToStudent() {
        System.out.println("Learning chemistry");
    }
}
