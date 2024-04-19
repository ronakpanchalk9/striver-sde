import java.util.ArrayList;

public class subsetSum {
    static void solve(ArrayList<Integer> arr, int idx, int N, int sum){
        if(idx >= N){
            return;
        }
        sum += arr.get(idx);
        solve(arr, idx+1, N, sum);
        sum -= arr.get(idx);
        solve(arr, idx+1, N, sum);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            ans.add(solve(arr, i, N, sum));
        }
    }
}
