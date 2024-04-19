import java.lang.reflect.Array;
import java.util.*;

public class leftView {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    static void solve(Node root, ArrayList<Integer> ans, int depth){
        if(root == null){
            return;
        }
        if(ans.size()==depth){
            ans.add(root.data);
        }
        solve(root.left, ans, depth+1);
        solve(root.right, ans, depth+1);
    }
    public ArrayList<Integer> left(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        solve(root, ans, 0);
        return ans;
    }
}
