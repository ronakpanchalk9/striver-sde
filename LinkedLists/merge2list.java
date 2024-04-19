public class merge2list {
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
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode ans = null;
        while (l1 != null || l2 != null) {
            ListNode temp = new val(0);
            if(l1.val < l2.val){
                temp.val = l1.val;
            }else{
                temp.val = l2.val;
            }
            ans.next = temp;
            ans = ans.next;
        }
        if(l1 != null){
            ans.next = l1;
        }else{
            ans.next = l2;
        }

        return ans;
    }
    // OPTIMIZED
    public ListNode merge2(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
// Always keep l1 to the smaller value
        if(l1.val > l2.val){
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode res = l1;
        while (l1 != null && l2 != null) {
            ListNode tmp1 = null;
            while (l1 != null && l1.val <= l2.val) {
                tmp1 = l1;
                l1 = l1.next;
            }
            tmp1.next = l2;

            // the moment we get l1 bigger than l2 swap l1 and l2 because we always want l1 to the smaller value

            ListNode tmp2 = l1;
            l1 = l2;
            l2 = tmp2;
        }
        return res;
    }
}
