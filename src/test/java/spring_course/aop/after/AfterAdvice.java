package spring_course.aop.after;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_course.aop.AspectConfig;
import spring_course.aop.beans.Sorter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AspectConfig.class})
public class AfterAdvice {

    @Autowired
    private Sorter sorter;

    @Test
    public void runAfterMethod(){

        int[] arr = {5, 7 , 6, 1 , 3};

        // Run after returning advice and after advice
        int[] sorted = sorter.bubbleSort(arr);

        for (int number: sorted)
            System.out.printf("%d", number);

    }

}
