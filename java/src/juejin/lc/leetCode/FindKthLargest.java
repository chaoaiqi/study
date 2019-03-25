package juejin.lc.leetCode;

/**
 * 查找第K大元素
 */
public class FindKthLargest {
    /**
     * 基于快排查找
     *
     * @param arrays 数组
     * @param head   数组头
     * @param tail   数组尾
     * @param k      key
     * @return value
     */
    private int findKByQuick(int[] arrays, int head, int tail, int k) {
        int pivot = partition(arrays, head, tail);
        if (pivot > k - 1) {
            return findKByQuick(arrays, head, pivot - 1, k);
        } else if (pivot < k - 1) {
            return findKByQuick(arrays, pivot + 1, tail, k);
        }
//        pivot == k - 1
        System.out.println("k = " + (pivot + 1));
        printAll(arrays);
        return arrays[pivot];
    }

    /**
     * 分区函数
     *
     * @param arrays 数组
     * @param head   数组头
     * @param tail   数组尾
     * @return 分区点
     */
    private int partition(int[] arrays, int head, int tail) {
        int last = arrays[tail];
        int pivot = head;
        for (int j = head; j < tail; j++) {
            if (last < arrays[j]) {
                int tmp = arrays[pivot];
                arrays[pivot] = arrays[j];
                arrays[j] = tmp;
                ++pivot;
            }
        }
        int tmp = arrays[pivot];
        arrays[pivot] = arrays[tail];
        arrays[tail] = tmp;
        return pivot;
    }

    private void printAll(int[] arrays) {
        for (int array : arrays) {
            System.out.print(array + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] findArray = {2, 4, 1, 3, 6, 5};
        int k = 2;
        int kValue = findKthLargest.findKByQuick(findArray, 0, findArray.length - 1, k);
        System.out.print("第" + k + "大元素为" + kValue);
    }
}
