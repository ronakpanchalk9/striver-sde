class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d) {
        data = d;
        next = null;
        bottom = null;
    }
}

public class flattenLL {
    public Node flat(Node root) {
        Node l1 = root;
        Node l2 = root.next;
        Node ans = new Node(l1.data);
        Node ans_reset = ans;
        l1 = l1.bottom;
        while (l2 != null) {
            while (l1 != null && l2 != null) {
                Node temp = new Node(0);
                if (l1.data < l2.data) {
                    temp.data = l1.data;
                    l1 = l1.bottom;
                }else{
                    temp.data = l2.data;
                    l2 = l2.bottom;
                }
                ans.bottom = temp;
                ans = ans.bottom;
            }
            if(l1 != null){
                ans.bottom = l1;
            }else{
                ans.bottom = l2;
            }
            l1 = ans_reset;
            l2 = l2.next;
            ans = ans_reset;
        }
        return ans;
    }
}
