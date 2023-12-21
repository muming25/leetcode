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
    public ListNode reverseList(ListNode head) {
        ListNode left = null;
        ListNode right = null;
        if (head == null || head.next == null){
            return head;
        }
        left = head;
        head = head.next;
        left.next = null;
        while (head.next != null){
            right = head;
            head = head.next;
            right.next = left;
            left = right;
        }
        head.next = left;
        return head;
    }
}