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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return head;
        }

        ListNode firstListEnd = head;
        ListNode secondListHead = head;
        ListNode leftNode = null;
        ListNode rightNode = null;
        
        // go throught first part of list
        for (int i=1; i<left; i++){
            if (secondListHead.next != null) {
                firstListEnd = secondListHead;
                secondListHead = secondListHead.next;
            } else {
                return head;
            }
        }

        ListNode currentNode = secondListHead;
        if (currentNode == null || currentNode.next == null){
            return head;
        }
        leftNode = currentNode;
        currentNode = currentNode.next;

        // revert second part of list
        for (int i=left; i<right; i++){
            rightNode = currentNode;
            currentNode = currentNode.next;
            rightNode.next = leftNode;
            leftNode = rightNode;
        }

        // link first part of list to second part of list
        if (left > 1) {
            firstListEnd.next = leftNode;
        } else {
            firstListEnd.next = null;
            head = leftNode;
        }

        // link second part of list to third part of list
        secondListHead.next = currentNode;
        return head;
    }
}.