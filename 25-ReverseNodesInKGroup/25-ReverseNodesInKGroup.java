// Last updated: 7/20/2026, 10:12:48 AM
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode groupPrev = dummy;
        
        while (true) {
            // Find the k-th node from the current position
            ListNode kth = getKthNode(groupPrev, k);
            if (kth == null) {
                break; // Not enough nodes left to reverse, we are done
            }
            
            ListNode groupNext = kth.next;
            
            // Standard reverse algorithm for the k elements
            ListNode prev = groupNext; // Connect the tail of reversed group to groupNext
            ListNode curr = groupPrev.next;
            
            while (curr != groupNext) {
                ListNode nextTmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTmp;
            }
            
            // Fix the connection from the previous group's tail to the new head
            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp; // Move groupPrev to the end of the newly reversed group
        }
        
        return dummy.next;
    }
    
    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}