import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: Yan
 * @date: 2022/1/15
 *
 * 选择排序
 */
public class Code_02_SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 2, 8, 4, 1, 3, 0, -2, -10};
        selectionSort(arr);
        System.out.println("Selection sort: " + Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
