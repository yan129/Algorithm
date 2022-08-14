# Algorithm
## 十大经典排序算法
n：数据规模

k："桶"的个数

In-place：占用常数内存，不占用额外内存

Out-place：占用额外内存

稳定性：排序后 2 个相等键值的顺序和排序之前它们的顺序相同

|   排序算法   |   平均时间复杂度   |   最好情况   |   最坏情况   |   空间复杂度   |   排序方式   |   稳定性   |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|   冒泡排序   |   O(n²)   |   O(n)   |   O(n²)   |   O(1)   |   In-place   |   稳定   |
|   选择排序   |   O(n²)   |   O(n²)   |   O(n²)   |   O(1)   |   In-place   |   不稳定   |
|   插入排序   |   O(n²)   |   O(n)   |   O(n²)   |   O(1)   |   In-place   |   稳定   |
|   希尔排序   |   O(nlogn)   |   O(nlog²n)   |   O(nlog²n)   |   O(1)   |   In-place   |   不稳定   |
|   归并排序   |   O(nlogn)   |   O(nlogn)   |   O(nlogn)   |   O(n)   |   Out-place   |   稳定   |
|   快速排序   |   O(nlogn)   |   O(nlogn)   |   O(n²)   |   O(logn)   |   In-place   |   不稳定   |
|   堆排序   |   O(nlogn)   |   O(nlogn)   |   O(nlogn)   |   O(1)   |   In-place   |   不稳定   |
|   计数排序   |   O(n + k)   |   O(n + k)   |   O(n + k)   |   O(k)   |   Out-place   |   稳定   |
|   桶排序   |   O(n + k)   |   O(n + k)   |   O(n²)   |   O(n + k)   |   Out-place   |   稳定   |
|   基数排序   |   O(n * k)   |   O(n * k)   |   O(n * k)   |   O(n + k)   |   Out-place   |   稳定   |

