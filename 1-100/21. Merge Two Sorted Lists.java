/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode retNode = null;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val > l2.val){
            retNode = l2;
            l2 = l2.next;
        }else if(l1.val <= l2.val){
            retNode = l1;
            l1 = l1.next;
        }
        ListNode current = retNode;
        current.next = null;
        while(l1!=null && l2!=null){
            if(l1.val > l2.val){
                current.next = l2;
                l2 = l2.next;
                current = current.next;
                current.next = null;
            }else if(l1.val <= l2.val){
                current.next = l1;
                l1 = l1.next;
                current = current.next;
                current.next = null;
            }
        }
        if(l1 != null){
            current.next = l1;
        }else if(l2 != null){
            current.next = l2;
        }
        return retNode;
    }
}