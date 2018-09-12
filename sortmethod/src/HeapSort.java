import java.util.Arrays;

public class HeapSort {

    /**
     * 将第index个节点插入到堆中，并调整
     * @param arr
     * @param index
     */
    public void heapInsert(int[] arr, int index){

        while (arr[index] > arr[(index - 1) / 2 ]){
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }

    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void heapify(int[] arr, int index, int heapSize){

        int left = index * 2 + 1;
        while (left < heapSize){
            //先比较左右叶子节点谁大
            int lager = ((left + 1 < heapSize) && (arr[left] < arr[left + 1]))
                    ? left + 1 :
                    left ;
            //在比较较大叶子节点和父节点的大小
            lager = arr[lager] > arr[index] ? lager : index;
            if (lager == index){
                break;
            }
            swap(arr, index, lager);
            //向下调整
            index = lager;
            left = index * 2 + 1;

        }

    }

    public void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        //初次调整为大顶堆
        for (int i = 1; i < arr.length ; i ++){
            heapInsert(arr, i);
        }


        int heapSize = arr.length;
        swap(arr, 0, -- heapSize);


        while (heapSize > 0){
            heapify(arr,0, heapSize);
            swap(arr,0, -- heapSize );
        }

    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 9, 4, 7, 6, 1, 3, 8 };;
        new HeapSort().heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
