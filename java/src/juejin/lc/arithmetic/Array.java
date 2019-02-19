package juejin.lc.arithmetic;

/**
 * 1.支持动态扩容
 * 2.支持动态增删改查
 * @author mic
 *
 */
public class Array {
	/**
	 * 数组
	 */
	private int array[];
	/**
	 * 数组长度
	 */
	private int size;
	/**
	 * 数组中数据数量
	 */
	private int count;

	/**
	 * 有参构造函数
	 * 
	 * @param capacity 数组容量大小
	 */
	public Array(int capacity) {
		array = new int[capacity];
		size = capacity;
		count = 0;
	}

	/**
	 * 数组随机访问
	 * 
	 * @param index 查找目标下标
	 * @return
	 */
	public int find(int index) {
		if (index < 0 || index > count)
			return -1;
		return array[index];
	}

	/**
	 * 删除数组中指定对象
	 * 
	 * @param index 删除目标下标
	 * @return
	 */
	public boolean delete(int index) {
		if (index < 0 || index > count)
			return false;
		for (int i = index + 1; i < count; i++) {
			array[i - 1] = array[i];
		}
		--count;
		// 缩容
		if (count == array.length / 4 && array.length / 2 != 0) {
			arrayExpansion(array.length / 2);
			System.out.println("动态缩容....");
		}
		return true;
	}

	/**
	 * 向数组中插入
	 * 
	 * @param index 插入下标
	 * @param value 插入值
	 * @return
	 */
	public boolean insert(int index, int value) {
		if (index < 0 || index > count)
			return false;
		if (count == size) {
			arrayExpansion(size * 2);
			System.out.println("动态扩容....");
		}

		for (int i = count - 1; i > index; --i) {
			array[i + 1] = array[i];
		}
		array[index] = value;
		++count;
		return true;
	}

	/**
	 * 尾部插入
	 * 
	 * @param value 插入值
	 * @return
	 */
	public boolean insertToTail(int value) {
		if (count == size) {
			arrayExpansion(size * 2);
			System.out.println("动态扩容....");
		}
		array[count++] = value;
		return true;
	}

	/**
	 * 数组扩容
	 * 
	 * @param capacity 当前数组大小
	 * @return
	 */
	private boolean arrayExpansion(int capacity) {
		int[] newArray = new int[capacity];
		for (int i = 0; i < size; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
		return true;
	}

	/**
	 * 打印data数组
	 */
	public void printAll() {
		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Array array = new Array(10);
		for (int i = 0; i < array.size; ++i) {
			array.insert(i, i);
		}
		array.printAll();
		//扩容
		array.insert(10, 10);
		array.printAll();
		//缩容
		for (int i = array.size; i > array.size/ 4; --i) {
			array.delete(i);
		}
		array.printAll();
	}
}
