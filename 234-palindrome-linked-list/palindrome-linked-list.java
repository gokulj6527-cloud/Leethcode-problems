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
        // Base case: empty list or single node is always a palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the linked list using fast & slow pointers
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // If the list length is odd, skip the middle element
        if (fast != null) {
            slow = slow.next;
        }

        // Step 2: Reverse the second half of the linked list
        slow = reverseList(slow);
        fast = head;

        // Step 3: Compare values from the first half and reversed second half
        while (slow != null) {
            if (fast.val != slow.val) {
                return false; // Return false immediately on mismatch
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true; // All matched
    }

    // Helper method to reverse a singly linked list iteratively
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}