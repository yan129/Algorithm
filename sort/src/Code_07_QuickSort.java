import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: Yan
 * @date: 2022/1/23
 *
 * 快速排序
 */
public class Code_07_QuickSort {
    public static void main(String[] args) {
        int[] arr = {40,5,12,7,9,323,1,34,3,89,34,9,0,-1,-23,5};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * @param arr 待排序数组
     * @param l 第一个元素下标
     * @param r 最后一个元素下标
     */
    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            //这一步为随机快排
            swap(arr, l + (int)(Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            }else if(arr[l] > arr[r]) {
                swap(arr, --more, l);
            }else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{ less + 1, more };
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
