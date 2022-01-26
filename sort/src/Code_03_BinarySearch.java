import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: Yan
 * @date: 2022/1/15
 *
 * 二分查找
 * 二分查找对数据要求必须是有序的，如果数据没有序，则需要先排序
 * 二分查找：返回查找到的索引，没有返回 -1
 */
public class Code_03_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2,6,1,8,9,4,0};
        Arrays.sort(arr);
        // 0 1 2 4 6 8 9
        System.out.println(binarySearch(arr, 6));

        int[] arr2 = {1,3,4,5,5,5,7,8,10};
        System.out.println(binarySearchLastValue(arr2, 5));

        System.out.println(bindSearchFirstGreatOrEqual(arr2, 5));

        System.out.println(bindSearchLastLessOrEqual(arr2, 5));
    }

    /**
     * 返回目标数的下标
     * @param arr 有序数组
     * @param target 目标数
     * @return 返回的下标，没找到返回 -1
     */
    private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int middle;

        while (low <= high) {
            middle = low + ((high - low) >> 1);
            if (arr[middle] > target) {
                high = middle - 1;
            }else if (arr[middle] < target) {
                low = middle + 1;
            }else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     */
    private static int binarySearchLastValue(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;

        while (low <= high) {
            middle = low + ((high - low) >> 1);
            if (arr[middle] > target) {
                high = middle - 1;
            }else if (arr[middle] < target) {
                low = middle + 1;
            }else {
                // 当arr[middle] == target，若middle = arr.length - 1,则middle肯定是第一个元素,或者a[middle+1]!=target,则middle后面的元素都是大于target的,
                // 因为数组是有序的,所以middle就是最后一个等于target的值
                // [4, 5, 5, 6]
                if (middle == arr.length - 1 || arr[middle + 1] != target) {
                    return middle;
                }else {
                    low = middle + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     */
    private static int bindSearchFirstGreatOrEqual(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int middle;

        while (low <= high) {
            middle = low + ((high - low) >> 1);
            if (arr[middle] >= target) {
                if (middle == 0 || arr[middle - 1] < target){
                    return middle;
                }else {
                    high = middle - 1;
                }
            }else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一位小于等于给定值的元素
     */
    private static int bindSearchLastLessOrEqual(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int middle;

        while (low <= high) {
            middle = low + ((high - low) >> 1);
            if (arr[middle] > target) {
                high = middle - 1;
            }else {
                if (middle == arr.length - 1 || arr[middle + 1] > target) {
                    return middle;
                }else {
                    low = middle + 1;
                }
            }
        }
        return -1;
    }
}
