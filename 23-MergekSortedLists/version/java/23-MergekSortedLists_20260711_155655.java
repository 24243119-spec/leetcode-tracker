// Last updated: 7/11/2026, 3:56:55 PM
1import java.util.PriorityQueue;
2
3class Solution {
4    public ListNode mergeKLists(ListNode[] lists) {
5        if (lists == null || lists.length == 0) return null;
6        
7        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
8        
9        for (ListNode node : lists) {
10            if (node != null) {
11                minHeap.add(node);
12            }
13        }
14        
15        ListNode dummy = new ListNode(0);
16        ListNode tail = dummy;
17        
18        while (!minHeap.isEmpty()) {
19            ListNode smallest = minHeap.poll();
20            tail.next = smallest;
21            tail = tail.next;
22            
23            if (smallest.next != null) {
24                minHeap.add(smallest.next);
25            }
26        }
27        
28        return dummy.next;
29    }
30}