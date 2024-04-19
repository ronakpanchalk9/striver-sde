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

public class reverseKnodes {
    public ListNode reverseGroups(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode nxt = null;
        ListNode curr = head;
        ListNode prev = null;
        ListNode nodeCounter = head;
        int nodecnt = 0;
        int count = 0;
        
        while (nodecnt < k && nodeCounter != null) {
            nodeCounter = nodeCounter.next;
            nodecnt++;
        }
        if (nodecnt < k) {
            return curr;
        }
        while (curr != null && count < k) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            count++;
        }

        if (nxt != null) {
            head.next = reverseKGroup(nxt, k);
        }

        return prev;
    }
}
