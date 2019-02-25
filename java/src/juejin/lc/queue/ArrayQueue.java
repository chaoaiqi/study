package juejin.lc.queue;

/**
 * 1.基于数组实现的顺序队列 2.队列中元素类型为int
 * 
 * @author mic
 *
 */
public class ArrayQueue {
	/**
	 * 数组
	 */
	private int[] arrays;
	/**
	 * 数组大小
	 */
	private int size;
	/**
	 * 队列队头下标
	 */
	private int head;
	/**
	 * 队列队尾下标
	 */
	private int tail;

	/**
	 * 初始化数组，申请一个大小为capacity大小的内存空间
	 * 
	 * @param capacity
	 */
	public ArrayQueue(int capacity) {
		arrays = new int[capacity];
		size = capacity;
		head = 0;
		tail = 0;
	}

	/**
	 * 入队
	 * 
	 * @param num
	 * @return
	 */
	public boolean enqueue(int num) {
		if (tail == size) {
			if(head == 0) return false;
			//数据搬移
			for (int i = head; i < tail; i++) {
				arrays[i-head] = arrays[i];
			}
			tail -= head;
			head = 0;
		}
		arrays[tail++] = num;
		return true;
	}

	/**
	 * 出队
	 * 
	 * @return
	 */
	public int dequeue() {
		if (head == tail)
			return -1;// 这里-1表示队空
		int res = arrays[head++];
		return res;
	}

	public void printAll() {
		for (int i = head; i < tail; ++i) {
			System.out.println("-----");
			System.out.println("| " + arrays[i] + " |");
		}
		System.out.println("-----");
		System.out.println();
	}

	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(5);
		for (int i = 1; i < 6; i++) {
			// 入队
			arrayQueue.enqueue(i);
		}
		arrayQueue.printAll();
		// 出队
//		int num = arrayQueue.dequeue();
//		System.out.println("出队：" + num);
//		arrayQueue.printAll();
	}

}
