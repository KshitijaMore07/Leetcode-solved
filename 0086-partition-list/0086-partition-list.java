class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);

        ListNode small = smallHead;
        ListNode large = largeHead;

        ListNode current = head;

        while(current != null){

            if(current.val < x){
                small.next = current;
                small = small.next;
            }
            else{
                large.next = current;
                large = large.next;
            }

            current = current.next;
        }

        
        large.next = null;

        
        small.next = largeHead.next;

        return smallHead.next;
    }
}