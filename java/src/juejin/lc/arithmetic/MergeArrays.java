package juejin.lc.arithmetic;

/**
 * 两个有序数组合并为一个有序数组
 * 
 * @author mic
 *
 */
public class MergeArrays {

	/**
	 * 方法1
	 * 
	 * @param array1 数组1
	 * @param m      数组1的大小
	 * @param array2 数组2
	 * @param n      数组2 的大小
	 * @return
	 */
	public int[] merge1(int[] array1, int m, int[] array2, int n) {
		int[] array3 = new int[m + n];
		int i = 0;
		int j = 0;
		int k = 0;
		// 通过一个while循环来进行添加
		while (i < m && j < n) {
			if (array1[i] < array2[j]) {
				// 将array1的元素加入array3，下标各加一
				array3[k++] = array1[i++];
			} else {
				// 将array2的元素加入array3，下标各加一
				array3[k++] = array2[j++];
			}
		}
		// 如果array1有剩余
		if (i != m) {
			while (i < m) {
				array3[k++] = array1[i++];
			}
		}
		// 如果array2有剩余
		if (j != n) {
			while (j < n) {
				array3[k++] = array2[j++];
			}
		}
		return array3;
	}

	/**
	 * 末尾排序法
	 * 
	 * @param array1
	 * @param m
	 * @param array2
	 * @param n
	 * @return
	 */
	public int[] merge2(int[] array1, int m, int[] array2, int n) {
		// 两个有序数组所有数组总和
		int num = m + n - 1;
		--m;
		--n;
		while (m >= 0 && n >= 0) {
			if (array2[n] > array1[m]) {
				array1[num--] = array2[n--];
			} else {
				array1[num--] = array1[m--];
			}
		}
		// 将n中剩余的数据加入array1
		while (n >= 0) {
			array1[num--] = array2[n--];
		}
		return array1;
	}

	/**
	 * 思路2还能更精简
	 * 
	 * @param array1
	 * @param m
	 * @param array2
	 * @param n
	 * @return
	 */
	public int[] mergeOpt2(int[] array1, int m, int[] array2, int n) {
		int num = m + n - 1;
		int i = m - 1;
		int j = n - 1;
		while (j >= 0) {
			array1[num--] = i >= 0 && array1[i] > array2[j] ? array1[i--] : array2[j--];
		}
		return array1;
	}

	/**
	 * 打印数组
	 * 
	 * @param array
	 */
	public void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MergeArrays mergeArrays = new MergeArrays();
//		int[] array1 = { 1, 2, 3};
//		int m = array1.length;
		int[] array1 = new int[6];
		array1[0] = 1;
		array1[1] = 2;
		array1[2] = 3;
		int m = 3;
		int[] array2 = { 4, 5, 6 };
		int n = array2.length;
//		int[] arrays = mergeArrays.merge1(array1, m, array2, n)(array1, m, array2, n);
//		int[] arrays = mergeArrays.merge2(array1, m, array2, n)(array1, m, array2, n);
		int[] arrays = mergeArrays.mergeOpt2(array1, m, array2, n);
		mergeArrays.print(arrays);

	}
}
