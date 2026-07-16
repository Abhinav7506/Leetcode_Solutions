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
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null) slow=slow.next;

        slow=reverseList(slow);
        fast=head;

        while(slow != null){
            if(fast.val != slow.val) return false;

            slow=slow.next;
            fast=fast.next;
        }
        return true;   
    }
    ListNode reverseList(ListNode head){
        ListNode front = null;
        ListNode prev=null;
        ListNode temp=head;
        while(temp!=null){
            front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;

    }
}