package juejin.lc.linkedList;

/**
 * 1.单链表的插入，删除，查询
 * 
 * @author mic
 */
public class SinglyLinkedList {
	/**
	 * 声明一个头节点
	 */
	private Node head;

	/**
	 * 1.插入
	 * 
	 * @param value
	 */
	public void insertTail(int value) {
		Node node = new Node(value, null);
		if (head == null) {
			head = node;
		} else {
			Node q = head;
			// 找到最后next一个为不空节点并赋值
			while (q.next != null) {
				q = q.next;
			}
			// 注意，顺序不可反，否则链表就断开了
			// 很精髓
			node.next = q.next;
			q.next = node;
		}
	}

	/**
	 * 2.删除
	 * 
	 * @param value
	 */
	public void deleteByNode(int value) {
		if (head == null)
			return;
		Node p = head;
		Node q = null;
		// 从链表中找到要删除的value
		while (p != null && p.data != value) {
			q = p;
			p = p.next;
		}
		if (p == null)
			return;
		if (q == null) {
			head = head.next;
		} else {
			// 删除节点，其实就是把要删除的值prev节点指向他的next节点
			// 很精髓
			q.next = q.next.next;
		}
	}

	/**
	 * 3.1 根据下标查询
	 * 
	 * @param index
	 */
	public Node findByIndex(int index) {
		Node p = head;
		int pos = 0;
		while (p != null && pos != index) {
			p = p.next;
			++pos;
		}
		return p;
	}

	/**
	 * 3.2 根据值查询
	 * 
	 * @param value
	 */
	public Node findByValue(int value) {
		Node p = head;
		while (p != null && p.data != value) {
			p = p.next;
		}
		return p;
	}

	public void printAll() {
		Node p = head;
		while (p != null) {
			System.out.print(p.data);
			p = p.next;
			if (p != null) {
				System.out.print("->");
			}
		}
		System.out.println();
	}
	public void print(Node node) {
		if(node != null) {
			System.out.println("查找结果:" + node.data);
		}else {
			System.out.println("不存在");
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		for (int i = 0; i < 7; i++) {
			// 插入
			singlyLinkedList.insertTail(i);
		}
		singlyLinkedList.printAll();
		// 删除
		singlyLinkedList.deleteByNode(6);
		singlyLinkedList.printAll();
		Node node1 = singlyLinkedList.findByIndex(2);
		singlyLinkedList.print(node1);
		Node node2 = singlyLinkedList.findByValue(2);
		singlyLinkedList.print(node2);
		Node node3 = singlyLinkedList.findByValue(66);
		singlyLinkedList.print(node3);
	}
}
