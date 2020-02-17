/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode swap(ListNode current){
        if(current == null){
            return null;
        }
        ListNode second = current.next;
        if(second == null){
            return current;
        }
        ListNode third = current.next.next;
        current.next.next = current;
        current.next = swap(third);
        return second;
    }
    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }
}