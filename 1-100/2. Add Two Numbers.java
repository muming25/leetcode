/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1 = l1,list2 = l2;
        ListNode output = null;
        ListNode current = null;
        int add = 0;
        while(list1!=null || list2!=null){
            int item1 = 0;
            if(list1!=null){
                item1 = list1.val;
            }
            
            int item2 = 0;
            if(list2!=null){
                item2 = list2.val;
            }
            
            int sumval = item1 + item2 + add;
            add = sumval / 10;
            sumval %= 10;
            
            ListNode newNode = new ListNode(sumval);
            if(current == null){
                output = newNode;
            }else{
                current.next = newNode;
            }
            current = newNode;
            if(list1!=null){
                list1=list1.next;
            }
            if(list2!=null){
                list2=list2.next;
            }
        }
        
        if(add > 0 && current!=null){
            current.next = new ListNode(add);
            current.next.next = null;
        }
        return output;
        
    }
}