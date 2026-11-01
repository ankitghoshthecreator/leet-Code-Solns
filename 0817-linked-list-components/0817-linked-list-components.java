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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int cnt=0;

        while(head!=null){
            if(set.contains(head.val)){
                if(head.next==null || !set.contains(head.next.val)){
                    cnt++;
                }
            }
            head=head.next;
        }return cnt;

    }
}