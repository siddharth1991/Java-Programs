package javaapplication1;

class LinkedListNode {
	int val;
	LinkedListNode leftNext;
	LinkedListNode rightNext;
	
	public LinkedListNode(int val) {
		this.val = val;
		this.leftNext = null;
		this.rightNext = null;
	}
}

public class BinaryTree {
	private LinkedListNode curNode = null;
	private LinkedListNode head = null;
	
	public void add(int val) {
		try {
			if (this.head == null)
				this.head = new LinkedListNode(100);
			if (val <= this.curNode.val) {
				if (this.curNode.leftNext == null) {
					LinkedListNode newNode = new LinkedListNode(val);
					this.curNode.leftNext = newNode;
					return;
				}
				this.add(val);
			}
			else if (val > this.curNode.val) {
				if (this.curNode.rightNext == null) {
					LinkedListNode newNode = new LinkedListNode(val);
					this.curNode.rightNext = newNode;
					return;
				}
				this.add(val);	
			}
		} catch (Exception e) {
			System.out.println(e);System.exit(0);
		}
	}
	
	public void print() {
		curNode = this.head;
		System.out.println(curNode.val);
		while(curNode.leftNext != null) {
			curNode = curNode.leftNext;
			System.out.println(curNode.val);
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.add(50);
		bt.add(90);
		bt.print();
	}

}
