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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }

        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode sec=slow.next;
        slow.next=null;

        ListNode prev=null;
        ListNode curr=sec;

        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        sec=prev;

        ListNode f=head;
        while(sec!=null){
            ListNode fN=f.next;
            ListNode sN=sec.next;

            f.next=sec;
            sec.next=fN;

            f=fN;
            sec=sN;
        }
    }
}