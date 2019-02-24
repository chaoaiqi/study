package juejin.lc.stack;

/**
 * 1.基于数组实现的顺序栈
 *  2.栈中元素类型为int
 * 
 * @author mic
 *
 */
public class ArrayStack {
	/**
	 * int型数组
	 */
	private int[] arrays;
	/**
	 * 栈的大小
	 */
	private int size;
	/**
	 * 栈中元素个数
	 */
	private int count;

	/**
	 * 有参构造函数
	 * 
	 * @param capacity 数组容量大小;
	 */
	public ArrayStack(int capacity) {
		arrays = new int[capacity];
		size = capacity;
		count = 0;
	}

	/**
	 * 入栈
	 * 
	 * @param num
	 * @return
	 */
	public boolean push(int num) {
		// 这里当数组空间不够时，入栈失败，暂不扩容
		if (count == size)
			return false;
		arrays[count] = num;
		++count;
		return true;
	}

	/**
	 * 出栈
	 * 
	 * @return
	 */
	public int pop() {
		// 栈空
		if (count == 0)
			return -1;//-1表示没有数据
		int res = arrays[count - 1];
		--count;
		return res;
	}

	public void printAll() {
		for (int i = count -1; i >= 0  ; --i) {
			System.out.println("-----");
			System.out.println("| " + arrays[i] + " |");
		}
		System.out.println("-----");
		System.out.println();
	}
	public static void main(String[] args) {
		ArrayStack arrayStack = new ArrayStack(5);
		for (int i = 1; i < 6; i++) {
			//入栈 
			arrayStack.push(i);
		}
//		arrayStack.printAll();
//		//出栈
		arrayStack.pop();
		arrayStack.printAll();
	}
}
