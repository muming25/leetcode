/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftListHead = null, leftListTail = null;
        ListNode rightListHead = null, rightListTail = null;
        while (head != null){
            ListNode nextNode = head.next;
            head.next = null;
            if (head.val < x) {
                //add to left;
                if(leftListHead == null){
                    leftListHead = head;
                    leftListTail = leftListHead;
                } else {
                    leftListTail.next = head;
                    leftListTail = head;
                }
            } else {
                //add to right;
                if(rightListHead == null){
                    rightListHead = head;
                    rightListTail = rightListHead;
                } else {
                    rightListTail.next = head;
                    rightListTail = head;
                }
            }
            head = nextNode;
        }

        //combine left and right
        if (leftListHead != null) {
            leftListTail.next = rightListHead;
            return leftListHead;
        } else {
            return rightListHead;
        }
    }
}