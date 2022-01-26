import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: Yan
 * @date: 2022/1/15
 *
 * 冒泡排序
 * 待排序：7 2 8 4 1 3
 * 第一轮：2 7 4 1 3 8	0~N-1 剩N-2
 * 第二轮：2 4 1 3 7 8	0~N-2 剩N-3
 * 第三轮：2 1 3 4 7 8	0~N-3 剩N-4
 * 第四轮：1 2 3 4 7 8	0~N-4 剩N-5
 *
 */
public class Code_00_BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 2, 8, 4, 1, 3, 0, -2};
        bubbleSortV1(arr);
        System.out.println("Bubble sort version 1: " + Arrays.toString(arr));

        arr = new int[]{7, 2, 8, 4, 1, 3, 0, -2};
        bubbleSortV2Optimization(arr);
        System.out.println("Bubble sort version 2 optimization: " + Arrays.toString(arr));

        arr = new int[]{7, 2, 8, 4, 1, 3, 0, -2};
        bubbleSortV3Optimization(arr);
        System.out.println("Bubble sort version 3 optimization: " + Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 第一版
     */
    private static void bubbleSortV1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e >= 0; e--) {
            for (int i = 0; i < e; i ++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i , i + 1);
                }
            }
        }
    }

    /**
     * 第二版
     * 如果能判断出数列已经有序，并做出标记，那么剩下的几轮排 序就不必执行了，可以提前结束工作.
     * 与第1版代码相比，第2版代码做了小小的改动，利用布尔变量isSorted作为标 记。如果在本轮排序中，元素有交换，则说明数列无序；如果没有元素交换，则说 明数列已然有序，然后直接跳出大循环.
     */
    private static void bubbleSortV2Optimization(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            // 有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    // 因为有元素进行交换，所以不是有序的，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 第三版
     * 在第3版代码中，sortBorder就是无序数列的边界。在每一轮排序过程中，处于sortBorder之后的元素就不需要再进行比较了，肯定是有序的.
     */
    private static void bubbleSortV3Optimization(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int lastExchangeIndex = 0;
        // 无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            // 有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    // 因为有元素进行交换，所以不是有序的，标记变为false
                    isSorted = false;
                    // 更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

}
