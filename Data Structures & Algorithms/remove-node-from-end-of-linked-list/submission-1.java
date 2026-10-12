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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = head; 

        int size = 1; 

        while (dummy.next != null) {
            size++; 
            dummy = dummy.next; 
        }

        // System.out.println(size); 

        //dummy at the end

        //move until dummy size - curr size == n - 1. 

            //, so do the .next function stuff when dummy - curr = n - 1. 

        if (n == size) return head.next; // removing head

        int x = 0; 

        ListNode curr = head; 

        while (curr.next != null) {
            if (size - x - 1 == n) { //2 - 1 == n 
                curr.next = curr.next.next; 
                break; 
            }
            x++; 
            curr = curr.next; 
        }

        return head; 
    }
}
