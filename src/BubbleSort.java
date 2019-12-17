import java.util.Arrays;

public class BubbleSort {

    static int[] bubbleSort(int[] arr){
        for(int i = 0; i <= arr.length; i++){
            for (int j = 0; j <= arr.length; j++){
                if(arr[i]>=arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] array = {1,6,2,6,8,1,8,324,12,7,3,2,2,2,6,68,12,4,46,1};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(bubbleSort(array)));
    }
}
