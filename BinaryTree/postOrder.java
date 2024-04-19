import java.util.ArrayList;
import java.util.*;

public class postOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode() {
        }
    
        TreeNode(int val) {
            this.val = val;
        }
    
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static void solve(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }
        if(root.left != null){
            solve(root.left, ans);
        }
        if(root.right != null){
            solve(root.right, ans);
        }
        ans.add(root.val);
    }
    public List<Integer> post(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        solve(root, ans);
        return ans;
    }
}
