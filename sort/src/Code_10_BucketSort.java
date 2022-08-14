import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: Yan
 * @date: 2022/2/19
 *
 * 桶排序
 * 1、在额外空间充足的情况下，尽量增大桶的数量
 * 2、使用的映射函数能够将输入的 N 个数据均匀的分配到 K 个桶中
 */
public class Code_10_BucketSort {
    public static void main(String[] args) {
        int[] arr = {40,5,12,7,9,323,1,34,3,89,34,9,0,-1,-2,5};
        System.out.println(Arrays.toString(bucketSort(arr)));
    }

    private static int[] bucketSort(int[] arr) {
        return bucketSort(arr, 5);
    }

    private static int[] bucketSort(int[] arr, int bucketSize) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        //计算桶个数
        int bucketCount = (int) Math.floor((max - min) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        //利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - min) / bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // 对每个桶进行排序，这里使用了插入排序
            bucket = insertSort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
        return arr;
    }

    private static int[] insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 自动扩容，并保存数据
     * @param arr
     * @param value
     * @return
     */
    private static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
