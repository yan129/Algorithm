import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: Yan
 * @date: 2022/2/13
 *
 * 堆排序
 * 1、创建一个最大堆
 * 2、把堆首（最大值）和堆尾互换
 * 3、把堆的尺寸缩小 1，并调用 heapify，目的是把新的数组顶端数据调整到相应位置
 * 4、重复步骤 2，直到堆的尺寸为 1
 */
public class Code_08_HeapSort {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6 };
        long start = System.currentTimeMillis();
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("=====");
        heapSort2(arr);
        System.out.println(Arrays.toString(arr));
        long stop = System.currentTimeMillis();
        System.out.println(stop - start);
    }

    public static void heapSort(int[] arr){
        int length = arr.length;

        buildMaxSort(arr, length);

        for (int i = length - 1; i > 0; i--) {
            swap(arr, 0, i);
            length--;
            heapify(arr, 0, length);
        }
    }

    private static void buildMaxSort(int[] arr, int length) {
        for (int i = (int)Math.floor(length / 2); i >= 0; i--){
            heapify(arr, i, length);
        }
    }

    private static void heapify(int[] arr, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < length && arr[left] > arr[largest]){
            largest = left;
        }

        if (right < length && arr[right] > arr[largest]){
            largest = right;
        }

        if (largest != i){
            swap(arr, i, largest);
            heapify(arr, largest, length);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 写法2
    public static void heapSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify2(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify2(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }
}

