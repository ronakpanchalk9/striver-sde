public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        while(head.next != null){
            head = head.next;
        }
        head.next = temp;
        
    }
}
