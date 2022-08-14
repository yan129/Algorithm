import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: Yan
 * @date: 2022/2/15
 *
 * 基数排序
 * 基数排序是非比较型整数排序算法，原理：将整数按位数切割成不同的数字，然后按每个位数分别比较。
 * 由于整数也可以表达字符串（比如名字或日期）和特定格式的浮点数，所以基数排序也不是只能使用于整数。
 */
public class Code_11_RadixSort {
    public static void main(String[] args) {
        int[] arr = {-112,-32,-45,-1,-3,0,23,56,12,35,89,1,4,-987,-92012,-7123,82741,92012};
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(radixSort(arr)));
        long stop = System.currentTimeMillis();
        System.out.println(stop - start);
    }

    public static int[] radixSort(int[] arr) {
        int maxDigit = getMaxDigit(arr);
        return radixSort(arr, maxDigit);
    }

    private static int[] radixSort(int[] arr, int maxDigit) {
        int dev = 1;
        int mod = 10;
        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];
            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
            }

            /**
             * 遍历排序数组
             */
            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }
        return arr;
    }

    private static int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    /**
     * 获取绝对值的最大数的位数（有几位）
     * @param arr
     * @return
     */
    private static int getMaxDigit(int[] arr) {
        int max = getMaxValue(arr);
        return getNumLength(max);
    }

    /**
     * 获取最大数的位数
     * @param max
     * @return
     */
    private static int getNumLength(int max) {
        if (max == 0) {
            return 1;
        }
        int length = 0;
        for (int tmp = max; tmp != 0; tmp /= 10) {
            length++;
        }
        return length;
    }

    /**
     * 获取绝对值的最大数
     * @param arr
     * @return
     */
    private static int getMaxValue(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        if (min < 0 && min * (-1) > max) {
            return min;
        }
        return max;
    }
}
