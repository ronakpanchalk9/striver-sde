import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.Queue;

public class bottomView {
    class Node {
        int data;
        int hd;
        Node left, right;

        Node(int item) {
            data = item;
            hd = Integer.MAX_VALUE;
            left = right = null;
        }
    }
    public ArrayList<Integer> bottomView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Map<Integer, Integer> mpp = new TreeMap<>();
        Queue<Node> q = new LinkedList<Node>();
        root.hd = 0;
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.remove();
            int hd = temp.hd;
            mpp.put(hd, temp.data);

            if(temp.left != null){
                temp.left.hd = hd-1;
                q.add(temp.left);
            }
            if(temp.right != null){
                temp.right.hd = hd+1;
                q.add(temp.right);
            }
        }
        for(Map.Entry<Integer, Integer> entry: mpp.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
