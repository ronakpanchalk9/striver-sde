public class removeNthfromBack {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp1 = head;
        ListNode temp = head;
        int total = 0;
        while(temp1 != null){
            total++;
            temp1 = temp1.next;
        }
        // temp = head;
        while(total > (n+1)){
            temp = temp.next;
            total--;
        }
        temp.next = temp.next.next;
        return head;
    }
}
