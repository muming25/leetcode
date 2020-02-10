/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private int found(ListNode past, ListNode current, int target){
        int now = 1;
        if(current.next!=null){
            now = found(current, current.next, target);
        }
        if(now == target){
            if(past != null){
                past.next = current.next;
            }
        }
        return now + 1;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = found(null,head,n);
        if(count == n+1){
            return head.next;
        }
        return head;
    }
}