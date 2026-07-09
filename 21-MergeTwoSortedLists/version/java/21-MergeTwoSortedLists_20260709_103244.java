// Last updated: 7/9/2026, 10:32:44 AM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) {
9 *         this.val = val;
10 *         this.next = next;
11 *     }
12 * }
13 */
14
15class Solution {
16    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
17
18        ListNode dummy = new ListNode(-1);
19        ListNode current = dummy;
20
21        while (list1 != null && list2 != null) {
22            if (list1.val <= list2.val) {
23                current.next = list1;
24                list1 = list1.next;
25            } else {
26                current.next = list2;
27                list2 = list2.next;
28            }
29            current = current.next;
30        }
31
32        if (list1 != null) {
33            current.next = list1;
34        } else {
35            current.next = list2;
36        }
37
38        return dummy.next;
39    }
40}