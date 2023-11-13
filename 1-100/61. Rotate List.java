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
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode nextHead = head;
        ListNode tail = head;
        ListNode before = null;
        while(nextHead != null){
            tail = nextHead;
            nextHead = nextHead.next;
            length++;
        }
        if(length == 0 ){
            return head;
        }
        k = k%length;
        if(k == 0){
            return head;
        }
        int z = length - k;
        nextHead = head;
        for(int i=0;i<z;i++){
            before = nextHead;
            nextHead = nextHead.next;
        }
        before.next = null;
        tail.next = head;
        return nextHead;
    }
}