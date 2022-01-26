import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: Yan
 * @date: 2022/1/16
 *
 * 希尔排序
 */
public class Code_04_ShellSort {
    public static void main(String[] args) {
        int[] arr = {40,5,12,7,9,323,1,34,3,89,34,9,0,-1,-23,5};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {

        if (arr == null || arr.length < 2){
            return;
        }

        int gap = 1;
        while (gap < arr.length / 3) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0 && arr[j] > arr[j + gap]; j -= gap) {
                    swap(arr, j, j + gap);
                }
            }
            gap = ((int) Math.floor(gap / 3));
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] =tmp;
    }
}
