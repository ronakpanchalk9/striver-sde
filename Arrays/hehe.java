import java.util.*;
public class hehe {
    public static void main(String[] args) {
        int xr = 0;
        int[] a = {4,2,2,6,4};
        int k = 6;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // prefix XOR till index i:
            xr = xr ^ a[i];
            System.out.println("XR: " + xr);
            //By formula: x = xr^k:
            int x = xr ^ k;
            System.out.println("X: " + x);
            // // add the occurrence of xr^k
            // // to the count:
            // if (mpp.containsKey(x)) {
            //     cnt += mpp.get(x);
            // }

            // // Insert the prefix xor till index i
            // // into the map:
            // if (mpp.containsKey(xr)) {
            //     mpp.put(xr, mpp.get(xr) + 1);
            // } else {
            //     mpp.put(xr, 1);
            // }
        }
    }    
}
