package juejin.lc.sorts;

/**
 * 五个必会的排序
 */
public class BaseSort {
    /**
     * 冒泡排序
     *
     * @param arrays 排序数组
     * @return 排序结果
     */
    private int[] bubbleSort(int[] arrays) {
        //第一个循环遍历，第二个循环比较
        for (int i = 0; i < arrays.length; i++) {
            //退出标记
            boolean flag = false;
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[i] > arrays[j]) {
                    int tmp = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
            System.out.print("第" + i + "次交换");
            printAll(arrays);
        }
        return arrays;
    }

    /**
     * 插入排序
     * 扑克牌思想
     *
     * @param arrays 排序数组
     * @return 排序结果
     */
    private int[] insertionSort(int[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            int value = arrays[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (value < arrays[j]) {
                    arrays[j + 1] = arrays[j];
                } else {
                    break;
                }
            }
            arrays[j + 1] = value;
            System.out.print("第" + i + "次交换");
            printAll(arrays);
        }
        return arrays;
    }

    /**
     * 选择排序
     *
     * @param arrays 排序数组
     * @return 排序结果
     */
    private int[] selectionSort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int minIndex = i;
            for (int j = i; j < arrays.length; j++) {
                if (arrays[j] < arrays[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = arrays[i];
            arrays[i] = arrays[minIndex];
            arrays[minIndex] = tmp;
            System.out.print("第" + i + "次交换:");
            printAll(arrays);
        }
        return arrays;
    }

    /**
     * 快速排序
     * 分而知之
     *
     * @param arrays 数组
     * @param head   数组头
     * @param tail   数组尾
     */
    private void quickSort(int[] arrays, int head, int tail) {
        if (head >= tail) {
            return;
        }
        // 获取分区点
        int pivot = partition(arrays, head, tail);
        quickSort(arrays, head, pivot - 1);
        quickSort(arrays, pivot + 1, tail);
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
        int pivot = arrays[tail];
        int i = head;
        for (int j = head; j < tail; ++j) {
            if (arrays[j] < pivot) {
                if(i == j) {
                    ++i;
                } else {
                    int tmp = arrays[i];
                    arrays[i++] = arrays[j];
                    arrays[j] = tmp;
                }
            }
        }
        int tmp = arrays[i];
        arrays[i] = arrays[tail];
        arrays[tail] = tmp;
//        System.out.println("i=" + i);
        return i;
    }

    /**
     * 归并排序
     *
     * @param arrays 数组
     * @param head   数组头
     * @param tail   数组尾
     */
    private void mergeSort(int[] arrays, int head, int tail) {
        if (head >= tail) return;
        int pivot = (head + tail) / 2;
        //分而治之
        mergeSort(arrays, head, pivot);
        mergeSort(arrays, pivot + 1, tail);
        //合并
        merge(arrays, head, pivot, tail);
    }

    /**
     * 合并
     *
     * @param arrays 数组
     * @param head   数组头
     * @param pivot  数组中间
     * @param tail   数组尾
     */
    private void merge(int[] arrays, int head, int pivot, int tail) {
        System.out.println("head=" + head + ",pivot=" + pivot + "tail=" + tail);
        int p = head;
        int q = pivot + 1;
        int k = 0;
        int[] tmp = new int[tail - head + 1];
        while (p <= pivot && q <= tail) {
            if (arrays[p] <= arrays[q]) {
                tmp[k++] = arrays[p++];
            } else {
                tmp[k++] = arrays[q++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = p;
        int end = pivot;
        if (q <= tail) {
            start = q;
            end = tail;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = arrays[start++];
        }

        // 将tmp中的数组拷贝回arrays
//        for (int i = 0; i <= tail - head; ++i) {
//            arrays[head + i] = tmp[i];
//        }
        //上述代码与下面代码等同，只不过idea有个警告，我就转换了一下
        if (tail - head + 1 >= 0)
            System.arraycopy(tmp, 0, arrays, head, tail - head + 1);
    }

    private void printAll(int[] arrays) {
        for (int array : arrays) {
            System.out.print(array + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BaseSort baseSort = new BaseSort();
        int[] arrays = {2, 4, 1, 3, 6, 5};
        int[] bubbleRes = baseSort.bubbleSort(arrays);
        System.out.print("冒泡排序:");
        baseSort.printAll(bubbleRes);
        int[] insertRes = baseSort.insertionSort(arrays);
        System.out.print("插入排序:");
        baseSort.printAll(insertRes);
        int[] selectRes = baseSort.selectionSort(arrays);
        System.out.print("选择排序:");
        baseSort.printAll(selectRes);

        int[] quickArray = {2, 4, 1, 3, 6, 5};
        baseSort.quickSort(quickArray, 0, quickArray.length - 1);
        System.out.print("快速排序:");
        baseSort.printAll(quickArray);
        int[] mergeArray = {2, 4, 1, 3, 6, 5};
        baseSort.mergeSort(mergeArray, 0, mergeArray.length - 1);
        System.out.print("归并排序:");
        baseSort.printAll(mergeArray);
    }
}
