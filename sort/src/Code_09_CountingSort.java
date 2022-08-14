import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: Yan
 * @date: 2022/2/13
 *
 * 计数排序
 * 使用条件：一是需要排序的元素必须是整数，二是排序元素的取值要在一定范围内，并且比较集中。
 * 第一步：找出原数组中元素值最大的，记为max.
 * 第二步：创建一个新数组count，其长度是max加1，其元素默认值都为0
 * 第三步：遍历原数组中的元素，以原数组中的元素作为count数组的索引，以原数组中的元素出现次数作为count数组的元素值.
 * 第四步：创建结果数组result，起始索引index.
 * 第五步：遍历count数组，找出其中元素值大于0的元素，将其对应的索引作为元素值填充到result数组中去，
 *      每处理一次，count中的该元素值减1，直到该元素值不大于0，依次处理count中剩下的元素.
 */
public class Code_09_CountingSort {
    public static void main(String[] args) {
        int[] arr1 = {40,5,12,7,9,323,1,34,3,89,34,9,0,5};
        System.out.println(Arrays.toString(countSortV1(arr1)));

        int[] arr2 = {40,5,12,7,9,323,1,34,3,89,34,9,0,-1,-2,5};
        System.out.println(Arrays.toString(countSortV2(arr2)));
    }

    /**
     * 版本一不能解决数组中有负数的排序
     * @param arr
     * @return
     */
    private static int[] countSortV1(int[] arr) {
        // 找出数组arr的最大值
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        // 初始化计数数组count
        int[] count = new int[max + 1];
        // 对计数数组各元素赋值
        for (int i : arr) {
            count[i]++;
        }
        // 创建结果数组的起始索引
        int index = 0;
        // 遍历计数数组，将计数数组的索引填充到结果数组中
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
        // 返回数组结果
        return arr;
    }

    /**
     * 解决数组中有负数的排序
     * 解决空间浪费问题
     * @param arr
     * @return
     */
    private static int[] countSortV2(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        // 找出数组arr的最大值和最小值
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        // 初始化计数数组count
        int[] count = new int[max - min + 1];
        // 对计数数组各元素赋值
        for (int i : arr) {
            count[i - min]++;
        }
        // 创建结果数组的起始索引
        int index = 0;
        // 遍历计数数组，将计数数组的索引填充到结果数组中
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i + min;
                count[i]--;
            }
        }
        return arr;
    }
}
