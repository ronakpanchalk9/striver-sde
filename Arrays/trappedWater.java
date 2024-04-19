public class trappedWater {
    public int solve(int[] nums){
        int[] lmax = new int[nums.length];
        int[] rmax = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(lmax[i]>max){
                max = lmax[i];
            }
            lmax[i] = max;
        }
        max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(rmax[i]>max){
                max = rmax[i];
            }
            rmax[i] = max;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += Math.min(lmax[i], rmax[i]) - nums[i];
        }
        return ans;
    }
}
