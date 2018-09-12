import java.util.Arrays;

public class BubbleSort {

    public void sort(int[] arr, int n){

        for (int i = 0; i < arr.length - 1; i ++){
            for (int j = 0; j < arr.length - 1 - i; j ++){
                if (arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void main(String[] args) {

        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        new BubbleSort().sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
