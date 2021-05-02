package spring_course.aop.afterreturning;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring_course.aop.AspectConfig;
import spring_course.aop.beans.Sorter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AspectConfig.class})
public class AfterReturningAdvice {

    @Autowired
    private Sorter sorter;

    @Test
    public void testAfterReturningAdvice(){

        int[] arr = {0, 6, 7, 2, 3, 10, 8};

        int[] sorted = sorter.bubbleSort(arr);

        for (int i : sorted)
            System.out.print(i + " ");

    }

}
