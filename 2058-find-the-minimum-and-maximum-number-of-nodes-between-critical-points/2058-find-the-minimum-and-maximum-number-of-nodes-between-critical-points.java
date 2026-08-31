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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev=head;
        ListNode curr=head.next;

        int index=1;

        int fCritPoint=-1;
        int lCritPoint=-1;

        int minDis=Integer.MAX_VALUE;

        while(curr.next!=null){
            boolean isCrit=(curr.val>prev.val && curr.val>curr.next.val)||(curr.val<prev.val && curr.val<curr.next.val);

            if(isCrit){
                if(fCritPoint==-1){
                    fCritPoint=index;
                }

                if(lCritPoint!=-1){
                    int dis=index-lCritPoint;
                    minDis=Math.min(dis, minDis);
                }
                lCritPoint=index;
            }
            prev=curr;
            curr=curr.next;
            index++;
        }

        if(lCritPoint==fCritPoint){
            return new int[]{-1,-1};
        }

        int maxD=lCritPoint-fCritPoint;
        return new int[] {minDis, maxD};
    }
}