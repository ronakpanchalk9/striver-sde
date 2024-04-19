import java.util.*;
public class preOrder {
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
    public List<Integer> preOrder(TreeNode root){
        List<Integer> q = new ArrayList<>();
        if(root == null){
            return q;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode tmp = st.peek();
            q.add(tmp.val);
            st.pop();

            if(tmp.right != null){
                st.push(tmp.right);
            }
            if(tmp.left != null){
                st.push(tmp.left);
            }
        }
        return q;
    }
}
