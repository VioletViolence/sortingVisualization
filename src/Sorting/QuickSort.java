package Sorting;

import java.util.Arrays;

public class QuickSort {
    static int count = 1;
    static int[] quickSort(int[] arr,int first,int last){
        if (first < last) {
            var pivotPoint = partition(arr,first,last);
            quickSort(arr,first,pivotPoint-1);
            quickSort(arr, pivotPoint+1,last);
        }
        return arr;
    };

    static int partition(int[] arr,int first,int last){
        int pivotValue = arr[first];
        int lowerPoint = first+1;
        int upperPoint = last;

        boolean done = false;

        while(!done){
            while(lowerPoint <= upperPoint && arr[lowerPoint] <= pivotValue){
                lowerPoint += 1;
            }
            while(arr[upperPoint] >= pivotValue && upperPoint >= lowerPoint){
                upperPoint -= 1;
            }


            if(upperPoint < lowerPoint){
                done = true;
            }
                    else{
                        int temp = arr[lowerPoint];
                        arr[lowerPoint] = arr[upperPoint];
                        arr[upperPoint] = temp;
                    }
        }
        int temp = arr[first];
        arr[first] = arr[upperPoint];
        arr[upperPoint] = temp;

        return upperPoint;
    }
    public static void main(String[] args) {
        int[] array = {1,6,2,6,8,1,8,324,12,7,3,2,2,2,6,68,12,4,46,1};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(quickSort(array, 0, array.length - 1)));
    }
}
