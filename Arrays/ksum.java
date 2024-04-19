import java.util.HashMap;

public class ksum {
    public int ksum(int[] arr, int n){
        int len = 0;
        int sum = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum == 0){
                len = Math.max(len, i+1);
            }
            if(mpp.containsKey(sum)){
                len = Math.max(len, i-mpp.get(sum));
            }else{
                mpp.put(sum, i);
            }    
        }
        return len;
    }
}
