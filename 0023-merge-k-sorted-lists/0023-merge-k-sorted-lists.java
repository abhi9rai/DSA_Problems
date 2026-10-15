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
    static class Compare implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq =
                new PriorityQueue<>(new Compare());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            temp.next = node;
            temp = temp.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }
}