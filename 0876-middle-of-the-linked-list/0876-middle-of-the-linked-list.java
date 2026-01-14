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
    public ListNode middleNode(ListNode head) {
        ListNode temp=new ListNode();
        temp=head;
        int length=0;
        while(temp != null)
        {
            length++;
            temp=temp.next;
        }
        int x=length/2;
        temp=head;
        while(x!=0)
        {
            temp=temp.next;
            x--;
        }
        return temp;
    }
}