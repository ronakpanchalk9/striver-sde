// Given an undirected graph with no self loops with V (from 0 to V-1) nodes and E edges, the task is to check if there is any cycle in the undirected graph.

// Note: Solve the problem using disjoint set union (DSU).

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class detectcCycle {
    int p[];
    public int detectCyclefunc(int V, ArrayList<ArrayList<Integer>> adj){
        p = new int[V];
        for (int i = 0; i < V; i++) {
            p[i] = i;
        }

        Set<String> s = new HashSet<>();

        for (int i = 0; i < adj.size(); i++) {
            for (int nb : adj.get(i)) {
                int xp = find(i);
                int yp = find(nb);

                if(xp!=yp){
                    p[xp] = yp;
                    s.add(""+i+""+nb);
                    s.add(""+nb+""+i);
                }else if(!s.contains(""+nb+""+i)){
                    return 1;
                }
            }
        }
        return 0;
    }
    int find(int v){
        if(p[v]==v){
            return p[v]==find(p[v]);
        }
    }
}
