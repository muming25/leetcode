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
        ListNode cur = head;
        ListNode last = null;
        
        while (cur != null){
            if(last != null && cur.val == last.val) {
                last.next = cur.next;
            }
            else {
                last = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}