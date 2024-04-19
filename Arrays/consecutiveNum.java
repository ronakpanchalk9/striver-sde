import java.util.HashMap;

public class consecutiveNum {
    public int consecutiveNumans(int[] nums){
        int n = arr.length;
        HashSet<Integer> ans = new HashSet<>();

        for (int i = 0; i < n; i++) {
            ans.add(arr[i]);
        }
        
        int temp = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if(!ans.contains(arr[i] - 1)){
                int currentnum = arr[i];
                temp = 1;

                while(ans.contains(currentnum+1)){
                    currentnum++;
                    temp++;
                }
            }

            if(temp > max){
                max = temp;
            }
        }
        return max;
    }
}
