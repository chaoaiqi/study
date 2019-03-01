package juejin.lc.search;

/**
 * 二分查找
 */
public class BinarySearch {
    /**
     * 递归
     *
     * @param arrays 数组
     * @param low    low
     * @param high   high
     * @param value  查找值
     * @return 返回值
     */
    private int bSearch(int[] arrays, int low, int high, int value) {
        if (low > high) return -1;//默认-1未找到
        //low + high如果足够大，相加之和容易溢出，因为换一种写法，并将其改成位运算
        int mid = low + ((high - low) >> 1);
        System.out.println("(" + low + " + " + high + ") / 2 = " + mid);
        if (arrays[mid] > value) {
            return bSearch(arrays, low, mid - 1, value);
        } else if (arrays[mid] < value) {
            return bSearch(arrays, mid + 1, high, value);
        }
        return mid;
    }

    /**
     * 二分查找非递归实现
     *
     * @param arrays 数组
     * @param value  查找值
     * @return 返回值
     */
    private int bSearch(int[] arrays, int value) {
        int low = 0;
        int high = arrays.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            System.out.println("(" + low + " + " + high + ") / 2 =" + mid);
            if (arrays[mid] > value) {
                high = mid - 1;
            } else if (arrays[mid] < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 查找一个有序数组中第一次出现给定值的元素
     *
     * @param arrays 数组
     * @param value  查找值
     * @return 返回值
     */
    private int bSFindFirst(int[] arrays, int value) {
        int low = 0;
        int high = arrays.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            System.out.println("(" + low + " + " + high + ") / 2 = " + mid);
            if (arrays[mid] >= value) {//将之前满足等于的放在左边
                high = mid - 1;
            } else if (arrays[mid] < value) {
                low = mid + 1;
            }
        }
        if (arrays[low] == value) return low;
        return -1;
    }

    /**
     * 查找一个有序数组中第一次出现给定值的元素
     *
     * @param arrays 数组
     * @param value  查找值
     * @return 返回值
     */
    private int bSFindFirstT(int[] arrays, int value) {
        int low = 0;
        int high = arrays.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            System.out.println("(" + low + " + " + high + ") / 2 = " + mid);
            if (arrays[mid] > value) {
                high = mid - 1;
            } else if (arrays[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || arrays[mid - 1] != value)
                    return mid;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找一个有序数组中最后一次出现给定值的元素
     *
     * @param arrays 数组
     * @param value  查找值
     * @return 返回值
     */
    private int bSFindLast(int[] arrays, int value) {
        int low = 0;
        int high = arrays.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            System.out.println("(" + low + " + " + high + ") / 2 = " + mid);
            if (arrays[mid] > value) {
                high = mid - 1;
            } else if (arrays[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == arrays.length - 1) || (arrays[mid + 1] != value))
                    return mid;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }

    private int[] createArrays(int length) {
        if (length < 1) return new int[0];
        int[] arrays = new int[length];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = i;
        }
        return arrays;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
//        int length = 101;
//        int[] arrays = binarySearch.createArrays(length);
//        int res = binarySearch.bSearch(arrays,0,arrays.length - 1,67);
//        System.out.println("result = " + res);
//        int res1 = binarySearch.bSearch(arrays,67);
//        System.out.println("result = " + res1);
        int[] repArrays = {1, 3, 3, 4, 6, 6, 6, 9, 10, 11};
//        int repRes = binarySearch.bSFindFirstT(repArrays,6);
//        System.out.println(repRes);
        int replRes = binarySearch.bSFindLast(repArrays,6);
        System.out.println(replRes);
    }
}
