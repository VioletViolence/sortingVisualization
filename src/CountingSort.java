import java.util.Arrays;

public class CountingSort {

    static int[] countingSort(int[] arr){

        // TODO: Fing array's mox number
            int max = 0;
        for (int number: arr) {
            if(number > max) max = number;
        }
        // TODO: Count number or mentions of numbers
        int[] countArray = new int[max+1];
        for (int number: arr) {
            countArray[number]++;
        }

        // TODO: Arrange an array from the bottom up
        int finalCounter = 0;
        for (int j = 0; j < countArray.length; j++) {
            while(countArray[j]>0){
                arr[finalCounter] = j;
                countArray[j]--;
                finalCounter++;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] array = {1,6,2,6,8,1,8,324,12,7,3,2,2,2,6,68,12,4,46,1};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(countingSort(array)));
    }
}
