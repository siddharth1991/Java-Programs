package javaapplication1;

/**
 *
 * @author siddharth
 */
class Node {
    public String val;
    public Node next;

    public Node(String val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedList {
    private Node head;
    private Node curNode;
    
    public void add(String val) {
        if (head == null)
            head = new Node("firstElement");
        Node node = new Node(val);
        curNode = head;
        while (curNode.next != null)
            curNode = curNode.next;
        curNode.next = node;
    }
    
    public void print() {
    	try {
	        curNode = this.head;
	        String list = curNode.val;
	        while(curNode.next != null) {
	        	list += "---------->";
	            curNode = curNode.next;
	            list += curNode.val;
	        }
	        System.out.println(list);
    	} catch (Exception e) {
            System.out.println(e.getMessage());
    	}
    }
    
    public void deleteFirstNode() {
    	this.head = this.head.next;
    }
    
    public void deleteMidNodes(String val) {
        curNode = this.head;
        while (curNode.next != null) {
        	 Node presentNode = curNode;
        	 curNode = curNode.next;
        	 if (curNode.val == val) {
        		presentNode.next = curNode.next;
        		break;
        	}
        }
    }

    public static void main(String args[]) {
        LinkedList linkedListObj = new LinkedList();
        linkedListObj.add("secondElement");
        linkedListObj.add("thirdElement");
        linkedListObj.add("fourthElement");
        linkedListObj.print();
        linkedListObj.deleteFirstNode();
        linkedListObj.print();
        linkedListObj.deleteMidNodes("thirdElement");
        linkedListObj.print();
    }
}