import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: Yan
 * @date: 2022/1/16
 *
 * 归并排序
 */
public class Code_05_MergeSort {
    public static void main(String[] args) {
        int[] arr = {40,5,12,7,9,323,1,34,3,89,34,9,0,-1,-23,5};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int middle = l + ((r - l) >> 1);
        mergeSort(arr, l, middle);
        mergeSort(arr, middle + 1, r);
        merge(arr, l, middle, r);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
}
