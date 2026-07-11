// Last updated: 7/11/2026, 3:58:32 PM
1class Solution {
2    public ListNode swapPairs(ListNode head) {
3        ListNode dummy = new ListNode(0);
4        dummy.next = head;
5        ListNode prev = dummy;
6        
7        while (prev.next != null && prev.next.next != null) {
8            ListNode first = prev.next;
9            ListNode second = prev.next.next;
10            
11            first.next = second.next;
12            second.next = first;
13            prev.next = second;
14            
15            prev = first;
16        }
17        
18        return dummy.next;
19    }
20}