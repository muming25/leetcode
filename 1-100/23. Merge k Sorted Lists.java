/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode[] LISTS;
    private ListNode head = null;
    private void insert(ListNode last, ListNode now, int index){
        if(now == null){
         ListNode newNode = new ListNode(index);
            if(last == null){
                head = newNode;
            }else{
                last.next = newNode;
            }
            newNode.next = null;
        }else if(LISTS[now.val].val < LISTS[index].val){
            insert(now, now.next, index);
        }else{
            ListNode newNode = new ListNode(index);
                newNode.next = now;
            if(last == null){
                head = newNode;
            }else{
                last.next = newNode;
            }
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ret = null;
        ListNode curr = null;
        LISTS = lists;
        int len = lists.length;
        int count = 0;
        for(int i=0;i<len;i++){
            if(lists[i]!=null){
                if(head == null){
                    head = new ListNode(i);
                }else{
                    insert(null, head, i);
                }
                count++;
            }
        }
        while(count > 0){
            int index = -1;
            if(ret != null){
                curr.next = LISTS[head.val];
                curr = curr.next;
            }else{
                ret = LISTS[head.val];
                curr = ret;
            }
            LISTS[head.val] = LISTS[head.val].next;
            curr.next = null;
            index = head.val;
            head = head.next;
            if(LISTS[index] != null){
                insert(null, head, index);
            }else{
                count--;
            }
        }
        return ret;
    }
}