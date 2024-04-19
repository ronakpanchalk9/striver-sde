public class subarrayXOR {
    public int solve(int arr[], int b){
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            int xor = 0;
            for (int j = i; j < arr.length; j++) {
                xor ^= arr[j];
                if(xor == b){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9};
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            System.out.println(xor);
        }
        // System.out.println(45^45);
    }
}
