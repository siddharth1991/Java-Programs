/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            System.out.println("List is empty");
            System.exit(0);
        }
        ListNode cur = head;
        while (head.next!=null && head.next.next != null) { //condition to check for last two nodes
            ListNode prev = null;
            while (cur.next != null) { //while we reach end of list
                prev = cur;
                cur = cur.next;
            }
            prev.next = cur.next;
            ListNode temp = head.next;
            head.next = cur;
            cur.next = temp;
            head = temp;
            cur = temp;
        }
    }
}

//time complexity : O(n^2)
//space complexity: O(1)
