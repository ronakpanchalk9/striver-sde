import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.Iterator;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
public class jobSequencing {
    public static int[] solve(Job[] arr, int n){
        int[] ans = new int[2];
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if(!mpp.containsKey(arr[i].deadline-1)){
                mpp.put(arr[i].deadline -1, arr[i].profit);
            }else{
                if(mpp.get(arr[i].deadline-1)<arr[i].profit){
                    mpp.put(arr[i].deadline-1, arr[i].profit);
                }
            }
        }
        ans[0] = mpp.size();
        int sum = 0;

        for(HashMap.Entry<Integer, Integer> mapElem: mpp.entrySet()){
            sum += mapElem.getValue();
        }
        ans[1] = sum;
        return ans;
    }
}
