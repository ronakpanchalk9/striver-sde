import java.util.HashMap;
import java.util.Scanner;

public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class palindromeCheck { 
    public boolean checkBoolean(ListNode head){
        if(head == null || head.next == null){
            return true;
        }
        ListNode tmp = head;
        ListNode prev = null;
        ListNode nxt = null;
        ListNode curr = head;
        int cnt = 0;
        while(tmp != null){
            tmp = tmp.next;
            cnt++;
        }
        tmp = head;
        int k = cnt/2;
        int tempcnt = 0;

        while(curr != null && tempcnt < k){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            tempcnt++;
        }

        tmp.next = nxt;
        tmp = tmp.next;
        if(cnt%2 != 0){
            tmp = tmp.next;
        }
        while(tmp != null){
            if(tmp.val != prev.val){
                return false;
            }
            tmp = tmp.next;
            prev = prev.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

		for (int  i = 0; i < args.length; i++) {
            int len = sc.nextInt();
            String s = sc.next();

            for (int j = 0; j < len; j++) {
                if(s.charAt(j) == '0'){
                    System.out.println("NO");
                }else if(s.charAt(j) == '1'){
                    if(j != len - 1){
                        System.out.println("IDK");
                    }else{
                        System.out.println("YES");
                    }
                }
            }
        }
    }
}
