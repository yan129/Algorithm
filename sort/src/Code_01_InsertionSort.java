import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: Yan
 * @date: 2022/1/15
 *
 * 插入排序
 * 与数据状况有关
 */
public class Code_01_InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 2, 8, 4, 1, 3, 0, -2, -10};
        insertionSort(arr);
        System.out.println("Insertion Sort: " + Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
