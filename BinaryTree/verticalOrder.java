import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.*;

public class verticalOrder {
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

    static class Pair {
        TreeNode node;
        int hd;
        int vd;

        Pair(int hd, int vd, TreeNode node) {
            this.vd = vd;
            this.hd = hd;
            this.node = node;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Map<Integer, PriorityQueue<Integer>> > mpp = new TreeMap<>();

        if (root == null) {
            return ans;
        }

        q.add(new Pair(0, 0, root));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int y = curr.hd;
            int x = curr.vd;
            TreeNode node = curr.node;

            if (!mpp.containsKey(x)) {
                mpp.put(x, new HashMap<>());
            } 

            if (!mpp.get(x).containsKey(y)) {
                mpp.get(x).put(y, new PriorityQueue<>());
            }

            mpp.get(x).get(y).offer(node.val);

            if (node.left != null) {
                q.offer(new Pair(curr.hd - 1, curr.vd + 1, node.left));
            }

            if (node.right != null) {
                q.offer(new Pair(curr.hd + 1, curr.vd + 1, node.right));
            }
        }

        for(Map<Integer, PriorityQueue<Integer>> entry: mpp.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes: entry.values()){
                while(!nodes.isEmpty()){
                    ans.get(ans.size()-1).add(nodes.poll());
                }
            }
        }
        return ans;
    }
}
