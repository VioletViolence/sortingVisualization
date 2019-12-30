package Sorting;

import java.util.Arrays;

public class MergeSort {

    static int[] mergesort(int[] arr){
        if(arr.length>1) {
            var mid = arr.length / 2;
            int[] leftarray = Arrays.copyOfRange(arr, 0, mid);
            int[] rightarray = Arrays.copyOfRange(arr, mid, arr.length);

            mergesort(leftarray);
            mergesort(rightarray);

            int leftIndex = 0;
            int rightIndex = 0;
            int finalIndex = 0;

            while(leftIndex < leftarray.length && rightIndex < rightarray.length){
                if(leftarray[leftIndex] < rightarray[rightIndex]){
                    arr[finalIndex] = leftarray[leftIndex];
                    leftIndex++;
                }else{
                    arr[finalIndex] = rightarray[rightIndex];
                    rightIndex++;
                }
                finalIndex++;
            }

            while(leftIndex < leftarray.length){
                arr[finalIndex] = leftarray[leftIndex];
                leftIndex++;
                finalIndex++;
            }

            while(rightIndex < rightarray.length){
                arr[finalIndex] = rightarray[rightIndex];
                rightIndex++;
                finalIndex++;
            }
        }
        return arr;
    };
    public static void main(String[] args) {
        int[] array = {1,6,2,6,8,1,8,324,12,7,3,2,2,2,6,68,12,4,46,1};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(mergesort(array)));
    }
}
