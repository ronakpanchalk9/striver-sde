import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class topView {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    class Pair{
        Node node;
        int hd;
        Pair(int hd, Node node){
            this.hd = hd;
            this.node = node;
        }
    }
    static ArrayList<Integer> topView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> mpp = new TreeMap<>();
        q.add(new Pair(0, root));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            if(!mpp.containsKey(curr.hd)){
                int temp = curr.node.data;
                mpp.put(curr.hd, temp);
            }
            if(curr.node.left != null){
                q.add(new Pair(curr.hd-1, curr.node.left));
            }
            if(curr.node.right != null){
                q.add(new Pair(curr.hd+1, curr.node.right));
            }
        }
        for(Map.Entry<Integer, Integer> entry: mpp.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
