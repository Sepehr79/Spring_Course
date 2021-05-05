package spring_course.aop.beans;

import org.springframework.stereotype.Component;

@Component
public class Sorter {

    // Some process will execute after returning result
    public int[] bubbleSort(int[] arr){

        for (int i = 0 ; i < arr.length ; i++){
            for (int j = 0 ; j < arr.length; j++){
                if (arr[i] < arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }

        return arr;
    }

}
