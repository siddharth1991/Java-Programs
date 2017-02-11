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
        node.next = curNode;
    }
    
    public void print() {
        String list = "";
        while(this.head.next != null)
            list += this.head.val;
        System.out.println(list);
    }
    
//    public boolean deleteFromPosition() {
//        
//    }
//    
//    public void updateValOnPosition() {
//        
//    }
//    
//    private int getSize(node) {
//        int count = 0;
//        while (node->next != NULL) {
//            node = node->next;
//            count++;
//        }
//    }

    public static void main(String args[]) {
        LinkedList linkedListObj = new LinkedList();
        linkedListObj.add("secondElement");
        linkedListObj.print();
    }
}