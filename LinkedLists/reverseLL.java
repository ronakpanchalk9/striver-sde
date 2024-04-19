public class reverseLL {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode nxt = head.next;
        while (nxt != null) {
            head.next = prev;
            prev = head;
            head = nxt;
            nxt = nxt.next;
        }
        return prev;
    }
}
