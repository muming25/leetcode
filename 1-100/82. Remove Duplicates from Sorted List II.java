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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = null;
        ListNode cur = head;
        ListNode last = null;
        ListNode last_new = null;
        int skip_val = -1000;
        int count = 0;
        while (cur != null) {
            boolean skip = false;
            if (cur.val == skip_val) {
                skip = true;
            } else if (cur.next != null && cur.val == cur.next.val) {
                skip = true;
            }
            
            if (skip) {
                skip_val = cur.val;
                if (cur.next == null && last != null) {
                    last.next = null;
                }
            } else {
                if (last == null) {
                    start = cur;
                } else {
                    last.next = cur;
                }
                last = cur;
            }
            cur = cur.next;
        }
        return start;
    }
}